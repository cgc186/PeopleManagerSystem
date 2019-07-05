/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_departmentDao;
import com.pojo.T_dept;
import com.pojo.T_employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updateDeptNumber() {
        List<T_dept> dl = getList();
        Map<Integer,Integer> dm = new HashMap<>();
        for (T_dept d : dl) {
            dm.put(d.getDno(), 0);
        }
        EmployService es = new EmployService();
        List<T_employee> el = es.Employ_list(false);
        for (T_employee e : el) {
            int dno = e.getDno();
            if(dm.containsKey(dno)){
                Integer t = dm.get(dno);
                t++;
                dm.replace(dno, t);
            }
        }
        for (Map.Entry<Integer, Integer> d : dm.entrySet()) {
            updateNumber(d.getKey(),d.getValue());
        }
    }
    private void updateNumber(int dno,int number){
        d.updateNumber(dno, number);
    }
}
    
    
