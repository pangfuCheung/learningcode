package com.yb.cheung.ibatis.statement;


import com.yb.cheung.ibatis.configuration.Configuration;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.处理需要被代理类的mapper.xml文件，把需要执行的sql和返回类型参数保存到map
 * 2.执行sql文件，返回数据库数据
 *  1）处理sql语句
 *  2）处理数据库返回类型，将数据转换成实体类
 */
public class StatementHandler {

    private Configuration configuration;

    private String mapKey;

    public StatementHandler(Configuration configuration,String mapKey) {
        this.configuration = configuration;
        this.mapKey = mapKey;
    }

    public List excute() throws Exception{
        List list = new ArrayList();
        Connection connection = configuration.getConnection();
        String sql = (String)configuration.getMethodMap().get(mapKey);
        String reType = (String)configuration.getTypeMap().get(mapKey);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            Class clazz = Class.forName(reType);
            Object clazzObj = clazz.newInstance();
            Field fields[] = clazz.getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                Field field = fields[i];
                field.setAccessible(true);
                Class typeClazz = field.getType();
                String value = rs.getString(field.getName());
                if(Integer.class == typeClazz){
                    field.set(clazzObj,Integer.valueOf(value));
                }else if(String.class == typeClazz){
                    field.set(clazzObj,String.valueOf(value));
                }
            }
            list.add(clazzObj);
        }
        return list;
    }
}
