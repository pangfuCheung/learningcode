package com.yb.cheung.practice;

public class AClass {

    public void method1(){
        System.out.println("AClass method1 .............");
    }
    public void method2(){
        System.out.println("AClass method2 .............");
    }
    public void method3(){
        System.out.println("AClass method3 .............");
    }
    public void method4(){
        System.out.println("AClass method4 .............");
    }

    public final void print(){
        method1();
        method2();
        method3();
        method4();
    }

}
