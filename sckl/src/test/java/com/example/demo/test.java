package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.cache.Cache;

/**
 * 	测试类
 * @author Zero-me
 *
 */
public class test {
	
	
	public static void main(String[] args) {
//		Hashtable ht = new Hashtable();
////		ht.put(null, "");
////		System.out.println(ht);
//		HashMap hm = new HashMap();
//		hm.put(null, "");
//		System.out.println(hm);
////		HashSet<E>
		
//		System.out.println(fun());
//		try {
//			System.out.println(fun1());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		int a = 1;
//		switch (a) {
//		case 1:
//			System.out.println("1");
//			break;
//		case 2:
//			System.out.println("2");
//			break;
//		default:
//			System.out.println("default");
//			break;
//		}
		
		String str = "zero";
		String newStr = new String("zero");
		System.out.println(str == "zero");
		System.out.println(str == newStr);
		
		
	}
	
	
	public static int fun() {
		try {
			System.out.println("1");
			int n = 2/0;
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 3;
		}finally {
			System.out.println(2);
		}
	}
	
	
	
	public static int fun1() throws Exception {
		int a = 1;
		try {
			
			a = 2;
			throw new Exception();
		} catch (Exception e) {
			throw new Exception();
		}finally {
			a= 3;
			return a;
		}
		
		
	}
	
	
	
	

	
}
