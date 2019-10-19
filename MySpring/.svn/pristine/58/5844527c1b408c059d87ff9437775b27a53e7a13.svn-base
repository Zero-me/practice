package com.zero.controller;

import javax.servlet.http.HttpServletRequest ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject ;
import com.zero.entity.ResultBean ;
import com.zero.service.UserService ;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultBean login(@RequestBody JSONObject json,HttpServletRequest request) {
		return userService.login(json,request);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResultBean logout(HttpServletRequest request) {
		return userService.logout(request);
	}
	
	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public ResultBean changepwd(@RequestBody JSONObject json) {
		return userService.changepwd(json);
	}
	
}
