package com.zero.filter ;

import java.util.List;

import javax.servlet.FilterConfig ;
import javax.servlet.ServletException ;
import javax.servlet.ServletRequest ;
import org.apache.commons.lang3.StringUtils ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

import com.zero.entity.UserBean;
import com.zero.entity.UserOpertion ;
import com.zero.exception.UserAuthException;
import com.zero.manager.TokenManager ;
import com.zero.manager.UserManager ;
import com.zero.util.CheckUtil ;
import com.zero.util.ConfigUtil;
import com.zero.util.UserUtil ;

public class UserAuthFilter extends BaseSafeFilter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;
	
	private static final List<String> allowList;
	
	static {
		allowList = ConfigUtil.getInstance().getAllowlist();
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("UserAuthFilter init ...") ;
	}
	
	@Override
	protected boolean isNeedCheck(UserBean userBean) {
		return !(allowList.stream().anyMatch(x -> userBean.getOrignRequstUri().equals(x)));
	}
	@Override
	protected void check(UserBean userBean){
		logger.info(userBean.toString());
		if(userBean.isAuth()) {
			return;
		}
		logger.error("[check] token is illagel ...") ;
		throw new UserAuthException("token is illagel");
	}
	
	@Override
	public void destroy() {
		logger.info("UserAuthFilter destroy ...") ;
	}

	@Override
	protected void filterOrdercheck() {
		int order = UserUtil.getFilterOrder();
		logger.info("[filterOrdercheck] start " + order);
		if(1 != order) {
			logger.error("[filterOrdercheck] filter order is illagel" );
			CheckUtil.fail("filter order is illagel");
		}
		logger.info("[filterOrdercheck] pass");
		UserUtil.setFilterOrder(2);
	}

	
}