package com.zero.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * 将控制台的输出指定输出到文件
 * @author Zero-me
 *
 */
public class test1 {
	
	
	
	
	public static void main(String[] args) {
		
		
		
		try {
			
			File f=new File("F:/log/out.txt");
	        f.createNewFile();
	        FileOutputStream fileOutputStream = new FileOutputStream(f);
			PrintStream printStream = new PrintStream(fileOutputStream);
	        System.setOut(printStream);
	        System.out.println("默认输出到控制台的这一句，输出到了文件 out.txt");
	        
	        
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
	

}
