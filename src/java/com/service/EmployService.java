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

    private T_employeesDao employeesdao = new T_employeesDao();

    public List<T_employee> Employ_list(boolean isQuit) {
        List<T_employee> Employeeslist = employeesdao.selectEmployee(isQuit);
        return Employeeslist;
    }

    public void Employ_update(T_employee employee, boolean isQuit) {
        employeesdao.updateEmployee(employee,isQuit);
    }
    public void Employ_add(T_employee employee, boolean isQuit) {
        employeesdao.addEmployee(employee,isQuit);
    }
     public void Employ_dele(int eno, boolean isQuit) {
        employeesdao.deleteEmployee(eno,isQuit);
    }
     public T_employee getEmployeeById(int eno, boolean isQuit) {
        return employeesdao.getEmployeeById(eno,isQuit);
    }
}
