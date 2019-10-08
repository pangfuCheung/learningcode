package com.yb.cheung.ibatis.test;

import com.yb.cheung.ibatis.configuration.Configuration;
import com.yb.cheung.ibatis.dao.DeptDao;
import com.yb.cheung.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMain {

    @Test
    public void test(){
        Configuration configuration = new Configuration("mybatis.mapper");
        SqlSessionFactory session = new SqlSessionFactory(configuration);
        DeptDao dao = (DeptDao) session.getMapper(DeptDao.class);
        /*List list = dao.findAll();
        System.out.println(list);*/
    }

}
