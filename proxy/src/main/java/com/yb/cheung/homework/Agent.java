package com.yb.cheung.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类实现类
 */
public class Agent implements InvocationHandler {

    private DongWu obj;

    public Agent(DongWu param){
        this.obj = param;
    }

    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

        String methodName = method.getName();
        String className = obj.getClass().getName();
        className = className.substring(className.lastIndexOf(".")+1,className.length());
        System.out.println(className);

        if("eating".equals(methodName) && "Tanglang".equals(className)){
            chanheshui();
            method.invoke(obj,params);
            huangquechitanglang();
            end();
        }else{
            method.invoke(obj,params);
        }

        return null;
    }

    public void chanheshui() throws Exception{
        DongWu chan = ProxyFactory.newInstance(Chan.class);
        chan.eating();
    }

    public void huangquechitanglang() throws Exception{
        DongWu huangque = ProxyFactory.newInstance(Huangque.class);
        huangque.eating();
    }

    public void end(){
        System.out.println("谚语：螳螂扑蝉黄雀在后。。。。。。");
    }
}
