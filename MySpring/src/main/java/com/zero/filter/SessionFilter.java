package com.zero.filter;

import java.util.List ;
import javax.servlet.FilterConfig ;
import javax.servlet.ServletException ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import com.zero.entity.UserBean ;
import com.zero.entity.UserOpertion ;
import com.zero.util.CheckUtil ;
import com.zero.util.UserUtil ;

public class SessionFilter extends BaseSafeFilter{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("SessionFilter init ...") ;
	}
	
	@Override
	protected boolean isNeedCheck(UserBean userBean) {
		// TODO Auto-generated method stub
		return false ;
	}

	@Override
	protected void check(UserBean userBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void filterOrdercheck() {
		int order = UserUtil.getFilterOrder();
		logger.info("[filterOrdercheck] start " + order);
		if(2 != order) {
			logger.error("[filterOrdercheck] filter order is illagel" );
			CheckUtil.fail("filter order is illagel");
		}
		logger.info("[filterOrdercheck] pass");
	}
	
}
