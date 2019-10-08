package com.yb.cheung.practice;

public class TestMain {

    public static void main(String[] args) throws Exception {

        BaseServiceDemo test = ProxyFactoryDemo.newInstance(ProxyDemoImpl.class);
        test.major1();

    }

}
