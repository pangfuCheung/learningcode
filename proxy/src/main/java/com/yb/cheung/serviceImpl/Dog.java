package com.yb.cheung.serviceImpl;

import com.yb.cheung.service.BaseService;

public class Dog implements BaseService {

    public void eating(String food) {
        System.out.println("ken " + food);
    }

    public void wcing() {
        System.out.println("san tui li zhu");
    }
}
