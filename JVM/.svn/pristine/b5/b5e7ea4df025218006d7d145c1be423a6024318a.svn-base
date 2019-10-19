package com.zero.oom;

/**
 * 
 * @author Zero-me
 *
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String [] args) {
		JavaVMStackSOF s = new JavaVMStackSOF();
		try {
			s.stackLeak();
		} catch (Throwable e) {
			System.out.println("len=" + s.stackLength) ;
			throw e;
		}
	}
	
	
	
	
}
