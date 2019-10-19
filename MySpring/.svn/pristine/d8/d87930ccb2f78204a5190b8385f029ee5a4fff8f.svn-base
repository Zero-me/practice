package com.zero.manager;

import java.util.Date ;
import org.apache.commons.lang3.StringUtils ;
import com.zero.util.Base64Util ;

public class TokenManager {
	
	
	private static long EXPIRE_TIME = 24*60*60;
	
	public static String createToken(String userName) {
		if(StringUtils.isEmpty(userName)) {
			return "";
		}
		long currentTime = new Date().getTime();
		long expire = currentTime + EXPIRE_TIME ;
		StringBuffer token = new StringBuffer("U=");
		token.append(userName).append("&V=").append(expire);
		return Base64Util.encode(token.toString());
	}
	
	
	public static String getNameFromToken(String token) {
		if(StringUtils.isEmpty(token)) {
			return "";
		}
		String decode = Base64Util.decode(token);
		String[] decodes = decode.split("&");
		String name = decodes[0].substring(2);
		return name;
	}
}
