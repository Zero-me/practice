package com.zero.util;

import org.apache.commons.codec.binary.Base64 ;
import org.apache.commons.lang3.StringUtils ;

public class Base64Util {
	
	
	public static String encode(String str) {
		if(StringUtils.isEmpty(str)) {
			str = "";
		}
		return Base64.encodeBase64String(str.getBytes());
	}
	
	
	public static String decode(String base64String) {
		if(StringUtils.isEmpty(base64String)) {
			base64String = "";
		}
		byte[] bytes =  Base64.decodeBase64(base64String);
		return new String(bytes);
	}
}
