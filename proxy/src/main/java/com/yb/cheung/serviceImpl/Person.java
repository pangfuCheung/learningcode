package com.yb.cheung.serviceImpl;

import com.yb.cheung.service.BaseService;

public class Person implements BaseService {

    public void eating(String food) {
        System.out.println("chi " + food);
    }

    public void wcing() {
        System.out.println("la shi ....");
    }

}
