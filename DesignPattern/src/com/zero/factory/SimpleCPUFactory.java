package com.zero.factory;

public class SimpleCPUFactory {
	
	public static final int TYPE_INTEL = 1;// 因特尔处理器
    public static final int TYPE_AMD = 2;// AMD处理器
    
    public static CPU createCPU(int type) {
        switch (type) {
        case TYPE_INTEL:
            System.out.println("=====开始创建IntelCPU=====");
            System.out.println("=====此处省略很多个步骤...=====");
            System.out.println("=====成功创建IntelCPU=====");
            return new IntelCPU();
        case TYPE_AMD:
            System.out.println("=====开始创建AMDCPU=====");
            System.out.println("=====此处省略很多个步骤...=====");
            System.out.println("=====成功创建AMDCPU=====");
            return new AMDCPU();
        default:
            return null;
        }
    }
	
	
}
