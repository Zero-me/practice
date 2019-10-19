package com.zero.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zero.entity.UserBean;
import com.zero.service.LogService ;
import com.zero.util.UserUtil;

public abstract  class BaseSafeFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(BaseSafeFilter.class);
	
	protected static LogService logService;
	
	public static void setLogService(LogService logService) {
		logger.info("logService init...");
		BaseSafeFilter.logService = logService ;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("BaseSafeFilter init...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		UserBean userBean = UserUtil.getUserBean();
		filterOrdercheck();
		if(isNeedCheck(userBean)) {
			check(userBean);
		}
		chain.doFilter(request, response);
	}

	protected abstract boolean isNeedCheck(UserBean userBean);
	
	protected abstract void check(UserBean userBean);
	
	protected abstract void filterOrdercheck();

	
	@Override
	public void destroy() {
		logger.info("BaseSafeFilter destroy...");
	}

}
