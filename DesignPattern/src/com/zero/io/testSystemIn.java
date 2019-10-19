package com.zero.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 键盘输入
 * 
 * @author Zero-me
 *
 */
public class testSystemIn {

	public static void main(String[] args) {
		
//		fun1();
		fun2();
//		fun3();
		
	}
	
	
	
	/**
	 * 读取单个字符
	 * @return
	 */
	public static char fun1() {
		
		try {
			System.out.print("Enter a Char:"); 
	        char i;
			i = (char) System.in.read();
			System.out.println("your char is :"+i);
			return i;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} 
		
	}
	
	/**
	 * 读取String
	 * @return
	 */
	public static String fun2() {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String str = null; 
	     System.out.println("Enter your value:"); 
	     try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     System.out.println("your value is :"+str); 
		
		return str;
	}
	
	
	public static String fun3() {
		Scanner sc = new Scanner(System.in); 
        System.out.println("请输入你的姓名："); 
        String name = sc.nextLine(); 
        System.out.println("请输入你的年龄："); 
        int age = sc.nextInt(); 
        System.out.println("请输入你的工资："); 
        float salary = sc.nextFloat(); 
        System.out.println("你的信息如下："); 
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary); 
        return name;
	}
}
