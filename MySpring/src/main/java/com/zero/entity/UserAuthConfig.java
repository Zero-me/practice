package com.zero.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserAuthConfig {

	private int maxInvTime;
	
	private List<String> allowList; 
}
