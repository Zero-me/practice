package com.zero.test;

import java.util.ArrayList;

public class testClass {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<String> l2 = new ArrayList<>();
		System.out.println(l1.getClass() == l2.getClass());
		System.out.println(l1.getClass());
		
	}
}
