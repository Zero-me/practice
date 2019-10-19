package com.zero.factory;

import java.util.logging.Logger;

public class ReflectCPUFactory {

	public static <T extends CPU> T createCPU(Class<T> cls) {
        T cpu = null;
        try {
            System.out.println("=====开始创建CPU=====");
            System.out.println("=====此处省略很多个步骤...=====");
            System.out.println("=====成功创建CPU=====");
            cpu = (T) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpu;
    }
}
