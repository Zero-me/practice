package com.zero.factory;

public class test {

	
	public static void main(String[] args) {
		
		// 通过工厂创建并获取因特尔CPU
		CPU cpu = SimpleCPUFactory.createCPU(SimpleCPUFactory.TYPE_INTEL);
		// 输出CPU的品牌
		cpu.showBrand();
	}
}
