package com.zero.util;

import java.util.Locale ;
import com.zero.entity.UserBean;

public class UserUtil {
		
		private static final ThreadLocal<UserBean> TL_USERBEAN = new ThreadLocal<>();
		
		
		private static final ThreadLocal<Locale> TL_LOCAL = new ThreadLocal<>(); 
		
		private static final ThreadLocal<Integer> TL_FILTER_ORDER = new ThreadLocal<Integer>(); 
		
		public static int getFilterOrder() {
			return TL_FILTER_ORDER.get();
		}

		public static void setFilterOrder(int order) {
			TL_FILTER_ORDER.set(new Integer(order));
		}
		
		public static Locale getLocal() {
			return TL_LOCAL.get();
		}

		public static void  setLocal(Locale locale) {
			TL_LOCAL.set(locale);
		}
		
		public static UserBean getUserBean() {
			return TL_USERBEAN.get();
		}

		public static void  setUserBean(UserBean userBean) {
			TL_USERBEAN.set(userBean);
		}
		
		private UserUtil() {
		}
		
		public static void clearUserInfo() {
			TL_USERBEAN.remove();
			
			TL_LOCAL.remove();
			
			TL_FILTER_ORDER.remove();
		}

}
