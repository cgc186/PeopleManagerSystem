/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.DeptPay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.util.DbUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public boolean updateDepartment(DeptPay dp) {
        String sql = "UPDATE t_dept set budget=?,ActualBudget=? WHERE dno=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDouble(1, dp.getBudget());
            pst.setDouble(2, dp.getActualBudget());
            pst.setInt(3, dp.getDno());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
