package com.yb.cheung.ibatis.dao;

import com.yb.cheung.ibatis.bean.Dept;

import java.util.List;

public interface DeptDao {

    Dept findDeptDaoByNo();

    List findAll();

}
