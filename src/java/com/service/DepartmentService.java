/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_departmentDao;
import com.pojo.T_dept;
import java.util.List;

/**
 *
 * @author zhang
 */
public class DepartmentService {

    private T_departmentDao d = new T_departmentDao();

    public List<T_dept> getList() {
        return d.getList();
    }
}