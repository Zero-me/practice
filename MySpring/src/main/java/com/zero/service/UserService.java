package com.zero.service;

import javax.servlet.http.HttpServletRequest ;
import com.alibaba.fastjson.JSONObject ;
import com.zero.entity.ResultBean ;

public interface UserService {
	
	ResultBean login(JSONObject json,HttpServletRequest request);
	
	ResultBean logout(HttpServletRequest request);
	
	ResultBean changepwd(JSONObject json);
	
}
