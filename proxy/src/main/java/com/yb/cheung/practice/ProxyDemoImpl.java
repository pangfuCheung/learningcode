package com.yb.cheung.practice;

/**
 * 被监听接口的实现类
 */
public class ProxyDemoImpl implements BaseServiceDemo {

    public void major1() {
        System.out.println(ProxyDemoImpl.class.getName() + " : method major1 .... is run .... ");
    }

    public void major2() {
        System.out.println(ProxyDemoImpl.class.getName() + " : method major2 .... is run .... ");
    }
}
