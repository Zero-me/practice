package com.zero.manager;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;
import com.zero.dao.UserOpertionMapper;
import com.zero.entity.UserBean ;
import com.zero.entity.UserOpertion ;
import com.zero.util.DateUtils ;
import com.zero.util.UserUtil ;

@Component
public class OperationLogWrite {
	
	@Autowired
	private UserOpertionMapper userOpertionMapper;
	
	public void writeLog(String operation) {
		UserBean user = UserUtil.getUserBean();
		UserOpertion opt = new UserOpertion();
		opt.setOptName(operation);
		opt.setName(user.getUserName());
		opt.setUserIp(user.getUserIp());
		opt.setOptTime(DateUtils.getCurrentTime());
		userOpertionMapper.insert(opt);
	}
}
