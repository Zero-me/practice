package com.zero.manager;

import java.util.Map ;
import java.util.concurrent.ConcurrentHashMap ;
import com.zero.entity.AuthedUserBean ;

public class UserManager {
	
	private static final Map<String,AuthedUserBean> authedMap = new ConcurrentHashMap<>();

	
	public static void addAuthedUserBean(String sessionId,AuthedUserBean userbean) {
//		String name = TokenManager.getNameFromToken(token);
//		authedMap.keySet().stream().forEach((o) ->
//		{
//			if(authedMap.get(o).getUserName().equals(name)) {
//				authedMap.remove(o);
//			}
//		});
		authedMap.put(sessionId, userbean);
	}
	
	public static AuthedUserBean getAuthedUserBean(String sessionId) {
		return authedMap.get(sessionId);
	}
	
	public static boolean removeAuthedUserBean(String sessionId) {
		authedMap.remove(sessionId);
		return true;
	}
	
	
}
