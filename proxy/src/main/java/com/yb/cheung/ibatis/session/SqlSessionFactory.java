package com.yb.cheung.ibatis.session;

import com.yb.cheung.ibatis.configuration.Configuration;
import com.yb.cheung.ibatis.proxy.MyProxyAgent;

import java.lang.reflect.Proxy;

public class SqlSessionFactory {

    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public Object getMapper(Class classFile){
        MyProxyAgent myProxyAgent = new MyProxyAgent(configuration,classFile);
        Class classArrays[] = {classFile};
        Object $proxy = Proxy.newProxyInstance(classFile.getClassLoader(),classArrays,myProxyAgent);
        return $proxy;
    }

}
