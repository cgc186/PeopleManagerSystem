/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_employeesDao;
import com.pojo.T_employee;
import java.util.List;

/**
 *
 * @author zhang
 */
public class EmployService {

    private T_employeesDao ed = new T_employeesDao();

    public List<T_employee> Employ_list(boolean isQuit) {
        List<T_employee> Employeeslist = ed.selectEmployee(isQuit);
        return Employeeslist;
    }

    public void Employ_update(T_employee employee, boolean isQuit) {
        ed.updateEmployee(employee, isQuit);
    }

    public String Employ_add(T_employee employee, boolean isQuit) {
        boolean flag = ed.addEmployee(employee, isQuit);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public void Employ_dele(int eno, boolean isQuit) {
        T_employee e = getEmployeeById(eno, false);
        
        EventService eu = new EventService();
        eu.EmployeesLeftEvent(e);
        ed.addEmployee(e, true);
        ed.deleteEmployee(eno, isQuit);
        PayService ps = new PayService();
        ps.deleteBudget(e);
    }

    public T_employee getEmployeeById(int eno, boolean isQuit) {
        return ed.getEmployeeById(eno, isQuit);
    }

    public boolean updateEmployeeDept(int eno, boolean isQuit, int dno) {
        return ed.updateEmployeeDept(eno, isQuit, dno);
    }
}
