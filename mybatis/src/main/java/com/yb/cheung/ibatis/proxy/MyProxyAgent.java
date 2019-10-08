package com.yb.cheung.ibatis.proxy;

import com.yb.cheung.ibatis.configuration.Configuration;
import com.yb.cheung.ibatis.statement.StatementHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyAgent implements InvocationHandler {

    private Configuration configuration;

    private Class classFile;

    public MyProxyAgent(Configuration configuration,Class classFile) {
        this.configuration = configuration;
        this.classFile = classFile;
    }

    /**
     * proxy    代理类，相当于onclick方法；
     * method   代理类被监听的方法相当于onclick="method1"的method1
     * args     被监听的方法参数
     * return   被监听方法返回值 dao.findAll方法的返回值与此处返回的对象为同一个对象
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String classFullName = classFile.getName();
        int size = classFullName.lastIndexOf(".");
        String className = classFullName.substring(size+1);
        StatementHandler statement = new StatementHandler(configuration,className+"."+method.getName());
        return statement.excute();
    }
}
