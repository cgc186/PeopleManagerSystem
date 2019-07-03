/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_departmentDao;
import com.dao.T_payDao;
import com.pojo.T_dept;
import com.pojo.T_deptPay;
import com.pojo.T_employee;
import java.util.List;

/**
 *
 * @author 98530
 */
public class PayService {
    private T_payDao paydao = new T_payDao();

    public double countBugget(int dno) {
        double bugget = 0;
        T_departmentDao dd = new T_departmentDao();
        List<T_employee> deptMember = dd.getDeptMember(dno);
        T_dept dept = dd.getDeptById(dno);
        int count = 0;
        double esal = 0;
        double totalSal = 0;
        for (T_employee e : deptMember) {
            count++;
            esal = e.getEsal();
            totalSal += esal;
        }
        bugget = totalSal + count * dept.getDinsurance();
        return bugget;
    }
    
    public boolean add(int dno, double bugget, double ActualBudget){
        T_deptPay pay = new T_deptPay();
        pay.setDno(dno);
        pay.setBudget(bugget);
        pay.setActualBudget(ActualBudget);
        
        return paydao.addDeptPan(pay);
    }
    
    public List getList(){
        return paydao.selectDeptcost();
    }
    
    public void update(){
        paydao.updatePay();
    }
}
