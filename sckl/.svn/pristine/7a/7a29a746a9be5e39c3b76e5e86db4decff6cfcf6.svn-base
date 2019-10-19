package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDOMapper;
import com.example.demo.dataobject.UserDO;



@SpringBootApplication(scanBasePackages= {"com.example.demo"})
@RestController
@MapperScan("com.example.demo.dao")
public class ScklApplication {

	@Autowired
	private UserDOMapper userDOMapper;
	
	@RequestMapping("/")
	public String home() {
		UserDO userdo = userDOMapper.selectByPrimaryKey(1);
		if(userdo == null) {
			return "用户对象不存在";
		}
		return userdo.getName();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ScklApplication.class, args);
	}

}

