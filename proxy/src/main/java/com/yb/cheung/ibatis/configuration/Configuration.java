package com.yb.cheung.ibatis.configuration;

import org.apache.ibatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configuration {

    private Connection connection;

    public Configuration(String mapperPath){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root");
            init(mapperPath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    private Map methodMap = new HashMap();

    private Map typeMap = new HashMap();

    public Map getMethodMap() {
        return methodMap;
    }

    public Map getTypeMap() {
        return typeMap;
    }

    /**
     * 初始化mapper.xml文件
     */
    public void init(String mapperPath) throws Exception{
        File file = Resources.getResourceAsFile(mapperPath);
        String fileStr[] = file.list();
        for(int i=0;i<fileStr.length;i++){
            String fileName = fileStr[i];
            String className = fileName.substring(0,fileName.lastIndexOf("."));
            //System.out.println("className : "+className);
            InputStream in = Resources.getResourceAsStream(mapperPath +"/" +className+".xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputStreamReader(in));
            Element rootElement = document.getRootElement();
            String methodName = null;
            setMethodMapAndTypeMap(rootElement,methodName,className);
        }
    }

    private void setMethodMapAndTypeMap(Element rootElement,String methodName,String className){
        List<Attribute> attributeList = rootElement.attributes();
        for(int i=0;attributeList!=null&&attributeList.size()>0&&i<attributeList.size();i++){
            Attribute attribute = attributeList.get(i);
            String name = attribute.getName();
            String value = attribute.getText();
            if("id".equals(name)){
                methodName = value;
                methodMap.put(className+"."+methodName,rootElement.getStringValue());
            }else if("resultMap".equals(name)){
                typeMap.put(className+"."+methodName,value);
            }
            //System.out.println("name: " + name);
            //System.out.println("value: " + value);
        }
        //System.out.println("methodName: " + methodName);

        List<Element> elementList = rootElement.elements();
        for (int i=0;elementList!=null&&elementList.size()>0&&elementList.size()>i;i++){
            Element rElement = elementList.get(i);
            setMethodMapAndTypeMap(rElement,methodName,className);
        }
    }

    public void CloseConnection() throws Exception{
        if(connection!=null){
            connection.close();
        }
    }

}
