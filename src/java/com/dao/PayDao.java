/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Department;
import com.entity.DeptPay;
import com.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.util.DbUtil;
import com.util.PayUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 98530
 */
public class PayDao {

    public boolean addDeptPan(DeptPay dp) {
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
    //得到部门号
    public List<Integer> getDept() {
        List<Integer> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_dept" ;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                deptList.add(rst.getInt(1));
            }
            rst.close();
            pst.close();
            return deptList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }
    
    public void updatePay() {
        DepartmentDao dp= new DepartmentDao();
        List<Department> deptList =dp.selectDepartment();
        String sql = "UPDATE t_pay set budget=?,ActualBudget=? WHERE dno=?";
        PayUtil py= new PayUtil();
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            for(int i = 0; i < deptList.size(); i++){
                double ActualBudget = py.countBugget(deptList.get(i).getDno());
                System.out.println(ActualBudget);
                pst.setDouble(2, ActualBudget);
                pst.setInt(3, deptList.get(i).getDno());
                pst.executeUpdate();
            }
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
    public List<DeptPay> selectDeptcost() {
        List<DeptPay> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM t_pay";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                DeptPay dept = new DeptPay();
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
