package com.yb.cheung.util;

import com.yb.cheung.service.BaseService;
import com.yb.cheung.serviceImpl.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    //返回一个代理监听对象
    public static BaseService newInstance(){
        //0.创建被索要的类型的实例对象
        BaseService xiaoming = new Person();

        //1.拥有一个代理实现类对象
        //InvocationHandler agent = new Agent();
        InvocationHandler agent = new Agent(xiaoming);

        //2.申请/注册一个对特定行为监控对象（代理对象；他就是一个onclick监听对象）
        /**
         * loader 用来指向被监控的类文件在内存中真实地址;在此处BaseService就是被监听的对象
         *
         * interface 被监控的类所实现的接口，这个接口中所声明的方法就是需要被监控的行为
         *           也是主要业务行为名称
         *
         */

        Class classArry[]  = {BaseService.class};

        //BaseService 监听对象 = (BaseService)Proxy.newProxyInstance(BaseService.class.getClassLoader()/*loader*/,classArry/*interface*/,agent);

        BaseService 监听对象 = (BaseService)Proxy.newProxyInstance(Person.class.getClassLoader()/*loader*/,classArry/*interface*/,agent);

        return 监听对象;
    }

    //返回一个代理监听对象
    public static BaseService newInstance(Class classFile) throws Exception {
        //0.创建被索要的类型的实例对象
        BaseService 索要对象 = (BaseService)classFile.newInstance();

        //1.拥有一个代理实现类对象
        //InvocationHandler agent = new Agent();
        InvocationHandler agent = new Agent(索要对象);

        //2.申请/注册一个对特定行为监控对象（代理对象；他就是一个onclick监听对象）
        /**
         * loader 用来指向被监控的类文件在内存中真实地址;在此处BaseService就是被监听的对象
         *
         * interface 被监控的类所实现的接口，这个接口中所声明的方法就是需要被监控的行为
         *           也是主要业务行为名称
         *
         */

        Class classArry[]  = {BaseService.class};

        //BaseService 监听对象 = (BaseService)Proxy.newProxyInstance(BaseService.class.getClassLoader()/*loader*/,classArry/*interface*/,agent);

        BaseService 监听对象 = (BaseService)Proxy.newProxyInstance(classFile.getClassLoader()/*loader*/,classArry/*interface*/,agent);

        return 监听对象;
    }


}
