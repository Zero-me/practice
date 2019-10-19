package com.zero;

import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author Zero-me
 *	
 *
 *	实则是Runnable的加强版
 *	call（）方法为线程的执行体，可以有返回值，可以声明抛出异常
 *	
 *	1.创建Callable的实现类，并实现call方法，
 *	2、创建实现类的实例，使用FutureTask类来包装实例对象，
 *	3、使用FutureTask对象所谓Thread的target并启动线程
 *	4.调用FutureTask对象的get即可获取子线程执行结束后的返回值
 *	
 *
 */
public class testCallable implements Callable<Integer> {

	 // 实现call方法，作为线程执行体
    public Integer call(){
        int i = 0;
        for ( ; i < 100 ; i++ ){
            System.out.println(Thread.currentThread().getName()+ "\t" + i);
        }
        // call()方法可以有返回值
        return i;
    }
    public static void main(String[] args) {
        // 创建Callable对象
    	testCallable myCallableTest = new testCallable();
        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>(myCallableTest);
        for (int i = 0 ; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName()+ " \t" + i);
            if (i == 20){
                // 实质还是以Callable对象来创建、并启动线程
                new Thread(task , "callable").start();
               
            }
        }
        try{
            // 获取线程返回值
            System.out.println("callable返回值：" + task.get());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
