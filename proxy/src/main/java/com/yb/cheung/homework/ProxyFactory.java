package com.yb.cheung.homework;

import java.lang.reflect.Proxy;

/**
 * 动态代理工厂
 */
public class ProxyFactory {

    public static DongWu newInstance(Class classFile) throws Exception{

        DongWu dongWu = (DongWu)classFile.newInstance();

        Agent agent = new Agent(dongWu);

        Class classArry[] = {DongWu.class};

        DongWu 代理对象 =  (DongWu)Proxy.newProxyInstance(classFile.getClassLoader(),classArry,agent);

        return 代理对象;
    }

}
