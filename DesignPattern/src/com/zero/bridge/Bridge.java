package com.zero.bridge;
/**
 * 	桥接类
 * @author Zero-me
 *
 */
public class Bridge {
	
	private Phone phone;
	
	public Phone getPhone() {
        return phone;
    }
	
	 public void setPhone(Phone phone) {
	    this.phone = phone;
	}

	 
	 /* 桥接方法 */
    public void transfer(){
        System.out.println("正在为您转接...");
        phone.sayHello();
        System.out.println("");
    }
}
