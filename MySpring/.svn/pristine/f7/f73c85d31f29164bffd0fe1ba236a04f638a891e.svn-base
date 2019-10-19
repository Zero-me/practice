package com.zero.util;

import javax.servlet.http.Cookie ;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletUtil {

	private static final Logger logger = LoggerFactory.getLogger(ServletUtil.class);
	
	private static final String EMP = "";
	
	public static String WSS_SUB_PROTOCOL ;
		
	public  static String getHeaderToken(HttpServletRequest request) {
		String token = null;
		token = request.getHeader(Constants.HEAD_TOKEN);
		if(StringUtils.isEmpty(token)) {
			String swp = request.getHeader("Sec-WebSocket-Protocol") ;
			if(StringUtils.isNotEmpty(swp)) {
				String [] SecWebSocketProtocol = swp.split(",") ;
				WSS_SUB_PROTOCOL = SecWebSocketProtocol[0] ;
				if (SecWebSocketProtocol.length > 1) {
					token = SecWebSocketProtocol[1] ;
				}
			}
		}
		return token == null ? EMP : token;
	}
	
	public static String getSessionId(HttpServletRequest request) {
		String sessionId = null;
		if(null == request) {
			return EMP;
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if("JSESSIONID".equals(cookie.getName())) {
				sessionId = cookie.getValue();
			}
		}
		return null == sessionId ? EMP : sessionId;
	}
	
	public static String getOrignRequstUri(HttpServletRequest request) {
		String orignRequstUri = request.getHeader(Constants.HEAD_ORIGN_URI);
		if(StringUtils.isEmpty(orignRequstUri)) {
			orignRequstUri = request.getRequestURI();
		}
		return orignRequstUri == null ? EMP : orignRequstUri;
	}
	
	public static String getHeaderLang(HttpServletRequest request) {
		String lang = request.getHeader("Lang");
		return StringUtils.isEmpty(lang) ? "en" : lang;
	}
}
