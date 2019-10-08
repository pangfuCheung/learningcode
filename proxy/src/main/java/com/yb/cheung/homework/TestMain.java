package com.yb.cheung.homework;

public class TestMain {

    public static void main(String[] args) throws Exception {
        //DongWu tanglang = ProxyFactory.newInstance(Tanglang.class);
        //tanglang.eating();

        DongWu chan = ProxyFactory.newInstance(Chan.class);
        chan.eating();

    }

}
