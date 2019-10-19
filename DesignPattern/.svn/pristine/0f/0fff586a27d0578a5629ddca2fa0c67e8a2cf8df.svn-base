package com.zero.singleton;


/**
 * 单例模式
 * 	饿汉式
 * 	这个对象很饿，程序加载就创建实例，关键词，Static
 * 	空间换时间，不管对象是否被引用，都会创建这个实例
 * 
 * 
 * @author Zero-me
 *
 */
public class Singleton {
	//定义并静态初始化一个实例，只供内部调用  
    private static final Singleton instance = new Singleton(); 
    //提供一个供外部访问单例对象的静态方法，可以直接访问单例对象  
    public static Singleton getInstance() { 
        return instance;  
    } 
    //控制实例的唯一性
    private Singleton(){}  
    

}



/**
 * 懒汉式
 * 	在第一次调用的时候才创建实例，为了保证线程安全，加上了同步关键字才能保证只实例化一次。
 * 	
 * 	采用了时间换取空间的方式，但是同步关键字导致每次调用单例对象都是线程同步的，影响程序的性能，不推荐使用
 * 
 * 
 * @author Zero-me
 *
 */
class Singleton2 { 
	
    private static Singleton2 instance=null;  
    //为了保证线程安全，因此必须加上synchronized同步关键字
    public static synchronized Singleton2 getInstance() {  
        if(instance==null) {  
               instance=new Singleton2();  
        }  
        return instance;  
    }  
    private Singleton2(){}  
}

/**
 * 
 * 	双重检查式
 * 	在懒汉式的基础上，只在创建实例的时候加锁，同时保证了实例的唯一性，创建实例的时候也会判断对象是否存在
 * 	相对懒汉式，提高了性能，但是每次引用都会判断对象是否为空
 * 
 * @author Zero-me
 *
 */
class Singleton3 {
	
    private volatile static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if(instance == null) {
            //同步块，线程安全的创建实例
            synchronized (Singleton3.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    private Singleton3(){}
}


/**
 * 	静态内部类
 * 	基于饿汉式单例模式。不同的是在单例 类中声明一个静态内部类，在这个静态内部类中取静态实例化对象，通过
 * 	这个静态内部类来获取单例对象，关键词static class
 * 	
 * 	在内部类静态实例化单例对象，在启动加载外部的单例类时是不会实例化内部类的，因此也不会实例化单例对象，
 * 	只有在真正调用内部类的时候才会加载内部类，此时才会实例化单例对象，而每次获取单例对象都是通过静态类获取的
 * 	程序的性能不受到影响	
 * 
 * @author Zero-me
 *
 */
class Singleton4 {
    //静态内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到时才会装载
    private static class Singleton4Holder {
        //静态初始化器，由JVM来保证线程安全
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        //通过访问内部类的成员变量来获取单例对象。
        return Singleton4Holder.instance;
    }

    private Singleton4(){}
}


/**
 * 	这里的singleton就是单例类的实例。直接用Singleton5.singleton就可以拿到单例对象实例，而且自动实现了序列化，
 * 	绝对实现实例对象的唯一性，和线程安全，是更简洁 高效，安全的实现单例的方式
 * 
 * @author Zero-me
 *
 */
 enum Singleton5 {
    singleton
}

 interface one{
	 abstract void  test();
 }
 interface two extends one{
	 
 }
 abstract class three implements one{
	 
 }

 
 /**
  * 总结
  * 	懒汉式和双重检查锁存在一定程度的性能浪费，不推荐
  * 	饿汉式不能实现延迟加载，但是实现方式最基本最方便理解
  * 	静态内部类可以实现延迟加载
  * 	枚举方式最为简洁安全高效
  * 	在实际环境中，饿汉式、静态内部类、枚举方式都可以使用
  * 
  * 
  * 
  */





