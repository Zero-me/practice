package com.zero.composite;

public class test {

	
	
	public static void main(String[] args) {
		Menu rootMenu=new Menu("一级菜单", "首页");
		Menu SecMenu1=new Menu("二级菜单","菜单1");
		Menu SecMenu2=new Menu("二级菜单","菜单2");
		Menu ThrMenu1=new Menu("三级菜单","菜单1");
		Menu ThrMenu2=new Menu("三级菜单","菜单2");
		//一级菜单放入二级菜单
		rootMenu.add(SecMenu1);
		rootMenu.add(SecMenu2);
		//二级菜单1放入三级菜单
		SecMenu1.add(ThrMenu1);
		SecMenu1.add(ThrMenu2);

		rootMenu.toString("");
	}
}
