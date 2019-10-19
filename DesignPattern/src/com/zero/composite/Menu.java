package com.zero.composite;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	/* 菜单等级 */
    String level;
    /* 菜单名称 */
    String name;
    /* 子菜单 */
    List<Menu> menuList = new ArrayList();

    public Menu(String level, String name) {
        this.level = level;
        this.name = name;
    }

    public void add(Menu menu) {
        menuList.add(menu);
    }

    public void remove(Menu menu) {
        menuList.remove(menu);
    }

    /** 打印 */
    public void toString(String str) {
        System.out.println(str + "level:" + this.level + ", name:" + this.name);
        str = str + "   ";
        for (Menu menu : menuList) {
            menu.toString(str);
        }
    }
}
