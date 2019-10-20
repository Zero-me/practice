package com.zero;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 
 * 	在这种情况下，程序所创建的Runnable对象只是线程的target。而多个线程可以共享一个target
 * 	多个线程可以共享同一个线程类，即线程的target的实例对象
 * 
 * 
 * 梵蒂冈fsfsfs
 * 
 * @author Zero-me
 *
 */
public class testRunnable implements Runnable {

	 private int i;
	 
	   void print(){
         System.out.println(Thread.currentThread().getName() + "-" + i);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (; i < 100; i++) {
            // 当线程类实现Runnable接口时，
            // 如果想获取当前线程，只能用Thread.currentThread()方法。
            print();
        }
	}


    /**
     * 获取属性
     */
    public static void getpppp(){
	       // TODO 防晒霜s   
        System.out.println("dsad打印撒asddXX");
    }
	public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            if (i == 20) {
            	//多个线程共享st
            	testRunnable st = new testRunnable();
                // 通过new Thread(target , name)方法创建新线程
                new Thread(st, "新线程-1").start();
                new Thread(st, "新线程-2").start();
            }
        }
    }
}
