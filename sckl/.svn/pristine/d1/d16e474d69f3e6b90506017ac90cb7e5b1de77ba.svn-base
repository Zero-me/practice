package com.example.demo.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;

        //打印请求Url

        System.out.println("this is MyFilter,ddd :" + req.getHeader("ddd"));
        System.out.println("Origin:"+req.getHeader("Origin"));
        System.out.println("Upgrade:"+req.getHeader("Upgrade"));
        System.out.println("Referer:"+req.getHeader("Referer"));
        System.out.println("tassIP:"+req.getHeader("tassIP"));

//        chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
