package com.zero.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

public class XSS {
	public static void main(String[] args) {
		String str = "<chast><>ds * d javascript: <script>";
		String ss = StringEscapeUtils.escapeHtml4(str);
		System.out.println(ss);
		System.out.println(HtmlUtils.htmlEscape(str));
		System.out.println(JavaScriptUtils.javaScriptEscape(str));
		
		
	}
}
