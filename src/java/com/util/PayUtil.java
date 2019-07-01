/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.entity.Employee;
import java.util.List;

/**
 *
 * @author 98530
 */
public class PayUtil {

    public double countBugget(int dno) {
        double bugget = 0;
        DepartmentDao dd = new DepartmentDao();
        List<Employee> deptMember = dd.getDeptMember(dno);
        Department dept = dd.getDepartmentById(dno);
        int count = 0;
        double esal = 0;
        double totalSal = 0;
        for (Employee e : deptMember) {
            count++;
            esal = e.getEsal();
            totalSal += esal;
        }
        bugget = totalSal + count * dept.getDinsurance() + dept.getDcost();
        return bugget;
    }
}
