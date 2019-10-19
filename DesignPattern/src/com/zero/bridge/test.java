package com.zero.bridge;

public class test {

	
	
	public static void main(String[] args) {
		Bridge bridge=new Bridge();//创建电话转接器
		bridge.setPhone(new Number1());//接到电话，请求转接到工号1001
		bridge.transfer();//进行转接
		bridge.setPhone(new Number2());//接到电话，请求转接到工号1002
		bridge.transfer();//进行转接
	}
}
