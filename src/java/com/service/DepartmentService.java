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

    public String addDepartment(T_dept dept) {
        Boolean u1 = d.addDepartment(dept);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String deleteDept(int dno) {
        Boolean u1 = d.deleteDept(dno);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String updateDepartment(T_dept dept) {
       Boolean u1 = d.updateDepartment(dept);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }
    public T_dept getDeptById(int dno) {
        return d.getDeptById(dno);
    }
}
