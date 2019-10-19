package com.zero.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileTransferTest {

	
	public static void main(String[] args) throws IOException {
			File source = new File("/Users/liuyingying/zero/学习文档/剑指offer第二版(PDF+源码).zip");
			File dest = new File("/Users/liuyingying/zero/学习文档/剑指offer第二版(PDF+源码).zip.io");
			File destnio = new File("/Users/liuyingying/zero/学习文档/剑指offer第二版(PDF+源码).zip.nio");
			System.out.println("io " +transferFile(source, dest) );
			System.out.println("nio " +transferFileWithNIO(source, destnio) );

					
	}
	
	
	public static long transferFile(File source, File des) throws IOException {

		long startTime = System.currentTimeMillis();
		        if (!des.exists()) {
		        	des.createNewFile();
		        }
		        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
		        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

		        //将数据源读到的内容写入目的地--使用数组
		        byte[] bytes = new byte[1024 * 1024];
		        int len;
		        while ((len = bis.read(bytes)) != -1) {
		            bos.write(bytes, 0, len);
		        }
		        long endTime = System.currentTimeMillis();
		        return endTime - startTime;
	}
	

	public  static long transferFileWithNIO(File source, File des) throws IOException {
	        long startTime = System.currentTimeMillis();
	        if (!des.exists()) {
	        	 des.createNewFile();
	        }
	        RandomAccessFile read = new RandomAccessFile(source, "rw");
	        RandomAccessFile write = new RandomAccessFile(des, "rw");

	        FileChannel readChannel = read.getChannel();
	        FileChannel writeChannel = write.getChannel();


	        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);//1M缓冲区

	        while (readChannel.read(byteBuffer) > 0) {
	            byteBuffer.flip();
	            writeChannel.write(byteBuffer);
	            byteBuffer.clear();
	        }
	        writeChannel.close();
	        readChannel.close();
	        long endTime = System.currentTimeMillis();
	        return endTime - startTime;
	    }
}
