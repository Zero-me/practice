package com.example.demo;

public class Parent {

	
	private int num = 1;
	{
		System.out.println("父类初始化代码块");
	}
	static {
		System.out.println("父类静态代码块");
	}
	
	public Parent() {
		System.out.println("父类无参构造方法");
	}
	public Parent(int num) {
		System.out.println(num+"父类有参构造方法");
	}
	public void test() {
		
		System.out.println("这是父类的test方法");
	}
	
}

