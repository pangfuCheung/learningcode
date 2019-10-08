package com.yb.cheung.test;

import com.yb.cheung.service.BaseService;
import com.yb.cheung.serviceImpl.Dog;
import com.yb.cheung.util.ProxyFactory;

public class TestMain {
    public static void main(String[] args) throws Exception {

        //实质拿到的是一个监听对象
        /*BaseService service = ProxyFactory.newInstance();
        service.eating("jitui");*/

        //BaseService xiaoming = new Person(); //丑陋的行为 对象不受监控的创建行为
        /*BaseService xiaoming = ProxyFactory.newInstance();
        xiaoming.eating("ya ");*/

        BaseService wancai = ProxyFactory.newInstance(Dog.class);
        wancai.eating(" ya");
        wancai.wcing();

    }

}
