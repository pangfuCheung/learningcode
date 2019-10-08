package com.yb.cheung.util;

import com.yb.cheung.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agent implements InvocationHandler {

    private BaseService obj; // 被开发人员索要的真实对象

    public Agent(BaseService param){
        this.obj = param;
    }

    //次要业务和主要业务的绑定

    /**
     *
     * @param proxy 本次负责监听的对象 ---- 相当于 onclick
     *
     * @param method 被拦截的主要业务方法
     *
     * @param params 被拦截主要业务方法接受的实数
     *
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

        //1.读取被拦截方法名称
        String methodName = method.getName();
        if("eating".equals(methodName)){//饭前洗手
            wash();
            //System.out.println(methodName + "is run .....");
            method.invoke(obj,params);
        }else{
            //System.out.println(methodName + "is run .....");
            method.invoke(obj,params);
            wash();
        }

        /*
        主要业务方法被拦截之后，主要业务的方法是在本方法内被调用的，因此它需要
        将方法的执行结果返回给代理对象（监听对象）
        * */
        return null;

    }

    //次要业务
    private void wash(){
        System.out.println("祈祷"); //解耦合
    }

}
