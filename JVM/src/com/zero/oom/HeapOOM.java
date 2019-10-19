package com.zero.oom;

import java.util.ArrayList ;
import java.util.List ;

/**
 * 	设置JAVA堆大小
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Zero-me
 *
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}
	
	public static void main(String [] args) {
		List<OOMObject> list = new ArrayList<>();
		while(true) {
			list.add(new OOMObject());
		}
	}
}
