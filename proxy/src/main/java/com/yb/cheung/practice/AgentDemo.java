package com.yb.cheung.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AgentDemo implements InvocationHandler {

    BaseServiceDemo obj;

    public AgentDemo(BaseServiceDemo param){
        this.obj = param;
    }

    /**
     *
     * @param proxy 代理对象 或 监听对象 --- 相当onclick
     * @param method 被监听接口的方法
     * @param params 被监听接口的方法实参
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

        String methodName = method.getName();
        if("major1".equals(methodName)){
            method.invoke(obj,params);
            minor();
        }else{
            minor();
            method.invoke(obj,params);
        }
        return null;
    }

    public void minor(){
        System.out.println("minor method ...... is run ......");
    }
}
