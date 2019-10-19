package com.zero.entity;

import com.zero.manager.UserManager ;
import lombok.Data;

@Data
public class UserBean {
	
		private String userName;
		
		private String userIp;
		
		private String token;
		
		private String OrignRequstUri;
		
		private String lang;
		
		private String sessionId;

		public UserBean(String userIp, String token, String orignRequstUri,String lang,String sessionId) {
			super();
			this.userIp = userIp;
			this.token = token;
			this.OrignRequstUri = orignRequstUri;
			this.lang = lang;
			this.sessionId = sessionId;
			
		}

		public boolean isAuth() {
			if(sessionId == null) {
				return false;
			}
			if(token == null) {
				return false;
			}
			AuthedUserBean authedUserBean = UserManager.getAuthedUserBean(sessionId);
			if(authedUserBean != null) {
				String authedToken = authedUserBean.getToken();
				if(token.equals(authedToken)) {
					String username = authedUserBean.getUserName();
					userName = username;
					return true;
				}
			}
			return false;
		}
		
		@Override
		public String toString() {
			return "UserBean [userName=" + userName + ", userIp=" + userIp + ", token=" + token + ", OrignRequstUri=" + OrignRequstUri + ", lang=" + lang
					+ ", sessionId=" + sessionId + "]" ;
		}

		

		
		
		
		
		
}
