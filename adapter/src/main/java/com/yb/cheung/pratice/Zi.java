package com.yb.cheung.pratice;

public class Zi extends AdapterFu {

    @Override
    public void zhuyaofangfa() {
        System.out.println("Zi类中实现的主要方法");
    }

    public void print(){
        zhuyaofangfa();
        super.chongfudaima1();
        super.chongfudaima2();
    }

}
