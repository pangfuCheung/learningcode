package com.yb.cheung.practice;

import java.lang.reflect.Proxy;

public class ProxyFactoryDemo {

    public static BaseServiceDemo newInstance (Class classFile) throws Exception{
        //0.动态创建一个被代理的接口类型的实现类
        BaseServiceDemo baseServiceDemo = (BaseServiceDemo)classFile.newInstance();
        //1.获得一个代理监听实现类
        AgentDemo agentDemo = new AgentDemo(baseServiceDemo);

        Class classArry[] = {BaseServiceDemo.class};
        BaseServiceDemo 监听对象 = (BaseServiceDemo)Proxy.newProxyInstance(classFile.getClassLoader(),classArry,agentDemo);

        return 监听对象;
    }

}
