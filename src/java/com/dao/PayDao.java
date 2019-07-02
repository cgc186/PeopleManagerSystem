/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.T_dept;
import com.entity.T_deptPay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.util.DbUtil;
import com.util.PayUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 98530
 */
public class PayDao {

    public boolean addDeptPan(T_deptPay dp) {
        String sql = "INSERT INTO t_pay (dno,budget,ActualBudget) VALUES(?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, dp.getDno());
            pst.setDouble(2, dp.getBudget());
            pst.setDouble(3, dp.getActualBudget());
            int count = pst.executeUpdate();
            pst.close();

            System.out.println(sql);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void updatePay() {
        DepartmentDao dd= new DepartmentDao();
        List<T_dept> deptList =dd.getList();
        String sql = "UPDATE t_pay set budget=?,ActualBudget=? WHERE dno=?";
        PayUtil pu= new PayUtil();
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (T_dept dept : deptList) {
                List<Integer> s = selectDept();
                double ActualBudget = pu.countBugget(dept.getDno());
                if(!s.contains(dept.getDno())){
                    T_deptPay dp = new T_deptPay();
                    dp.setDno(dept.getDno());
                    dp.setBudget(dept.getDcost());
                    dp.setActualBudget(ActualBudget);
                    addDeptPan(dp);
                }else{
                    pst.setDouble(1,dept.getDcost());
                    pst.setDouble(2, ActualBudget);
                    pst.setInt(3, dept.getDno());
                    pst.executeUpdate();
                }
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public List<Integer> selectDept() {
        List<Integer> dnoList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM t_pay";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                dnoList.add(rst.getInt("Dno"));
            }
            rst.close();
            pst.close();
            return dnoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dnoList;
    }
    
    public List<T_deptPay> selectDeptcost() {
        List<T_deptPay> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM t_pay";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_deptPay dept = new T_deptPay();
                dept.setDno(rst.getInt("Dno"));
                dept.setBudget(rst.getDouble("budget"));
                dept.setActualBudget(rst.getDouble("ActualBudget"));
                deptList.add(dept);
            }
            rst.close();
            pst.close();
            return deptList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }
}
