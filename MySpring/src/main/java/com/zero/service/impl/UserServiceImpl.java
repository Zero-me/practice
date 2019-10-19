package com.zero.service.impl;

import javax.servlet.http.Cookie ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpSession ;
import org.apache.commons.lang3.StringUtils ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Service ;
import com.alibaba.fastjson.JSONObject ;
import com.zero.dao.UsersMapper ;
import com.zero.entity.AuthedUserBean ;
import com.zero.entity.ResultBean ;
import com.zero.entity.Users ;
import com.zero.manager.TokenManager ;
import com.zero.manager.UserManager ;
import com.zero.service.UserService ;
import com.zero.util.CheckUtil ;
import com.zero.util.MsgKeyConstants ;
import com.zero.util.UserUtil ;


@Service
public class UserServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public ResultBean login(JSONObject json,HttpServletRequest request) {
		String name = json.getString("name");
		String pwd = json.getString("pwd");
		if(StringUtils.isAnyEmpty(name,pwd)) {
			CheckUtil.fail(MsgKeyConstants.INPUT_PRARM_EMPTY);
		}
		Users user = usersMapper.selectByName(name);
		if(user.getPwd().equals(pwd)) {
			
			String sessionId = createSession(request);
			String token = TokenManager.createToken(name);
			JSONObject res = new JSONObject();
			res.put("token", token);
			res.put("sessionId", sessionId);
			AuthedUserBean authBean = new AuthedUserBean(name, UserUtil.getUserBean().getUserIp(),token);
			UserManager.addAuthedUserBean(sessionId, authBean);
			UserUtil.getUserBean().setUserName(name);
			return ResultBean.newSuccessResult(res);
		}else {
			UserUtil.getUserBean().setUserName(name);
		}
		CheckUtil.fail(MsgKeyConstants.USER_LOGIN_FIALED);
		return ResultBean.newFailedResult("username or password is wrong");	
	}

	@Override
	public ResultBean logout(HttpServletRequest request) {
		String sessionId = UserUtil.getUserBean().getSessionId();
		UserManager.removeAuthedUserBean(sessionId);
		HttpSession session = request.getSession(false);
		if(null != session) {
			session.invalidate();
		}
		return ResultBean.newSuccessResult(true);
	}

	@Override
	public ResultBean changepwd(JSONObject json) {
		String oripwd = json.getString("orignpasswd");
		String newpwd = json.getString("newpwd");
		String repeatnewpwd = json.getString("repeatnewpwd");
		if(StringUtils.isAnyEmpty(oripwd,newpwd,repeatnewpwd)) {
			return ResultBean.newFailedResult("param empty");
		}
		if(!newpwd.equals(repeatnewpwd)) {
			return ResultBean.newFailedResult("newpwd if twice is different");
		}
		String name = UserUtil.getUserBean().getUserName();
		Users user = usersMapper.selectByName(name);
		if(user.getPwd().equals(oripwd)) {
			user.setPwd(newpwd);
			usersMapper.updateByPrimaryKey(user);
			UserManager.removeAuthedUserBean(UserUtil.getUserBean().getToken());
			return ResultBean.newSuccessResult("changepwd success");
		}
		return null ;
	}
	
	
	private String createSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(null != session) {
			session.invalidate();
		}
		session = request.getSession(true);
		return session.getId();
	}
	
}
