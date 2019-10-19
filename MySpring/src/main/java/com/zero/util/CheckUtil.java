package com.zero.util;

import org.springframework.context.MessageSource ;
import com.zero.exception.CheckException ;

public class CheckUtil {
	
	
	private static MessageSource messageSource;
	
	public static void  setMessageSource(MessageSource message) {
		messageSource = message;
	}
	
	
	public static void fail(String message) {
		throw new CheckException(messageSource.getMessage(message,null,UserUtil.getLocal()));
	}
}
