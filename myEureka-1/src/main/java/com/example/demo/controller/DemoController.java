package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/")
public class DemoController {
	
	@RequestMapping(value="/demo")
	public String demo() {
		return "这里是myEureka-1";
	}
	
	
}
