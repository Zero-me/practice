package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.error.BusinessException;
import com.example.demo.error.EmBusinessError;

import response.CommonReturnType;


@CrossOrigin(allowCredentials="true",allowedHeaders= "*")
public class BaseController {

	public static final  String CONTENT_TYPE_FORMED="application/x-www-form-urlencoded";

	/*  定义exceptionhandler解决未被controller处理的exception*/
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handlerException(HttpServletRequest req,Exception e) {
		Map<String, Object> responseData = new HashMap<String, Object>();
		if(e instanceof BusinessException) {
			BusinessException ex = (BusinessException)e;
			responseData.put("errCode", ex.getErrCode());
			responseData.put("errMsg", ex.getErrMsg());
		}else {
			responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
			responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
		}
		return CommonReturnType.create("Failed",responseData);
	}
	
	
	
	
	
	
	
}
