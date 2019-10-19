package com.zero.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testReadFile {

	public static void main(String[] args) {
		
		System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));
		System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
		System.out.println(Integer.parseInt("128") == Integer.valueOf("128"));
		
	}
	
	
	public static void fun(String[] args) {
		FileReader fr = null;
		BufferedReader br = null; 
		try {
			fr = new FileReader("F:\\log\\sckl\\logback.xml");
			br = new BufferedReader(fr);
			String str;
			System.out.println("=============================="+ (char)br.read());
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
