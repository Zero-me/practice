package com.zero.controller;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.servlet.ModelAndView ;
import com.zero.entity.ResultBean ;
import com.zero.entity.UserOpertion ;
import com.zero.service.LogService ;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean add(@RequestBody UserOpertion userOpertion) {
		return  logService.add(userOpertion);
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public ResultBean seeLog() {
		return  logService.getAll();
	}
	
}
