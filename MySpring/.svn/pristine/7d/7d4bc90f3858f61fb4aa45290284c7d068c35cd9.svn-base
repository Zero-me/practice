package com.zero.filter;

import java.io.IOException;
import java.util.Locale ;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zero.entity.UserBean;
import com.zero.manager.TokenManager ;
import com.zero.util.ServletUtil;
import com.zero.util.UserUtil;
import com.zero.util.Constants;

public class ClientInfoFilter implements Filter{
	
	
		private static final Logger logger = LoggerFactory.getLogger(ClientInfoFilter.class);
		
		private static final String WEBSOCKET_URI = "/api/websocket";
		
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			logger.info("ClientInfoFilter init...");
		}
		
		@Override
		public void destroy() {
			logger.info("ClientInfoFilter destroy...");
		}

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {

				setUserBean(getUserBean((HttpServletRequest)request));
				HttpServletResponse httpResponse = (HttpServletResponse)response;
				if(UserUtil.getUserBean().getOrignRequstUri().contains(WEBSOCKET_URI)) {
					httpResponse.setHeader(Constants.HEAD_WSS_PROTOCOL,ServletUtil.WSS_SUB_PROTOCOL);
				}
				chain.doFilter(request, httpResponse);
				UserUtil.clearUserInfo();
		}
		
		
		private void setUserBean(UserBean userBean) {
			UserUtil.setUserBean(userBean);
			UserUtil.setLocal(new Locale(userBean.getLang()));
			UserUtil.setFilterOrder(1);
		}
		
		private UserBean getUserBean(HttpServletRequest request) {
			
			String token = ServletUtil.getHeaderToken(request);
			String userIp = request.getRemoteAddr();
			String orignRequestUri = ServletUtil.getOrignRequstUri(request);
			String name = TokenManager.getNameFromToken(token);
			String lang = ServletUtil.getHeaderLang(request);
			String sessionId = ServletUtil.getSessionId(request);
			UserBean userBean = new UserBean(userIp, token, orignRequestUri,lang,sessionId);
			userBean.setUserName(name);
			return userBean;
		}
		
		
		
}
