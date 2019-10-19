package com.zero.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class testByteBuffer {
		public static void main(String[] args) throws IOException {
			test2();
			
			
			
		}
		
		public static void test2() throws IOException {
			FileInputStream fis = new FileInputStream(new File("/Users/liuyingying/zero/学习文档/剑指offer第二版(PDF+源码).zip"));
			FileChannel channel = fis.getChannel();
			channel.open(Paths.get("/Users/liuyingying/zero/学习文档/剑指offer第二版(PDF+源码).zipchannel"), StandardOpenOption.CREATE);
		}
		
		public static void test1() {
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put("123".getBytes());
			bb.flip();
			byte[] b = new byte[bb.limit()];
			bb.get(b);
			System.out.println(new String(b));
		}
}
