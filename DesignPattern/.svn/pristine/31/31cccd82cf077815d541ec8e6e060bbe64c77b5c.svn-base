package com.zero.decorator;

public class test {
	
	
	public static void main(String[] args) {
		Sourceable sourceable= new RealSource();//创建被装饰对象
		Decorator decorator=new Decorator();//创建装饰者对象
		decorator.setSourceable(sourceable);//将被装饰对象放到装饰者里面进行装饰
		decorator.lawsuit();//由装饰者对象对外提供服务  
	}
}
