package com.zero.io;

import java.io.File;

public class testListFile {

	
	
	
	public static void main(String[] args) {
		
		String filePath = "E:\\软件安装包\\java秒杀无密";
	}
	
	
	
	public static void listFile(String filePath) {
		if(filePath == null || "".equals(filePath)) {
			return;
		}
		File[] files = new File(filePath).listFiles();
		if(files == null) {
			return;
		}
		for(File file:files) {
			if(file.isFile()) {
				System.out.println(file.getName());
			}else if(file.isDirectory()) {
				System.out.println("----------------------------------------");
				System.out.println("Directory: " + file.getName());
				listFile(file.getPath());
			}else {
				System.out.println("Error");
			}
		}
		
	}
	
}
