/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_dept;
import com.pojo.T_employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.util.DbUtil;

/**
 *
 * @author 98530
 */
public class T_departmentDao {

    public List<T_dept> getList() {
        List<T_dept> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_dept";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_dept dept = new T_dept();
                dept.setDno(rst.getInt("dno"));
                dept.setDname(rst.getString("dname"));
                dept.setDtype(rst.getString("dtype"));
                dept.setDcost(rst.getDouble("dcost"));
                dept.setDinsurance(rst.getDouble("dinsurance"));
                dept.setFather(rst.getInt("father"));
                dept.setNumber(rst.getInt("number"));
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

    public boolean addDepartment(T_dept dept) {
        String sql = "INSERT INTO t_dept (dno,dname,dtype,dcost,dinsurance) VALUES(?,?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, dept.getDno());
            pst.setString(2, dept.getDname());
            pst.setString(3, dept.getDtype());
            pst.setDouble(4, dept.getDcost());
            pst.setDouble(5, dept.getDinsurance());
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDepartment(T_dept dept) {
        String sql = "UPDATE t_dept set dname=?,dtype=?,dcost=?,dinsurance=? WHERE dno=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, dept.getDname());
            pst.setString(2, dept.getDtype());
            pst.setDouble(3, dept.getDcost());
            pst.setDouble(4, dept.getDinsurance());
            pst.setInt(5, dept.getDno());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void updateNumber(int dno,int number){
        String sql = "update t_dept set number = ? where dno=?";
        DH.update(sql, new String[] {String.valueOf(number),String.valueOf(dno)});
    }

    public boolean updateDepartmentCost(double cost, int dno) {
        String sql = "UPDATE t_dept set dcost=? WHERE dno=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDouble(1, cost);
            pst.setInt(2, dno);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<T_employee> getDeptMember(int dno) {
        List<T_employee> employeeList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_employees where dno =" + dno;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {

                T_employee ep = new T_employee();
                ep.setEno(rst.getInt("eno"));
                ep.setEname(rst.getString("ename"));
                ep.setEsal(rst.getDouble("esal"));
                ep.setEsex(rst.getString("esex"));
                ep.setEage(rst.getInt("eage"));
                ep.setEtel(rst.getString("etel"));
                ep.setEnational(rst.getString("enational"));
                ep.setEtype(rst.getString("etype"));
                ep.setEin_date(rst.getDate("ein_date"));
                ep.setEculture(rst.getString("eculture"));
                ep.setDno(rst.getInt("dno"));
                employeeList.add(ep);
            }
            rst.close();
            pst.close();
            return employeeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public int getEmployeesCount(int dno) {
        int count = 0;
        Connection conn = DbUtil.getConnection();
        String sql = "select count(*) from t_employees where dno =" + dno;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                count = rst.getInt(1);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean deleteDept(int dno) {
        String sql = "delete from t_dept where dno = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, dno);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public T_dept getDeptById(int dno) {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_dept where dno =" + dno;
        T_dept dept = new T_dept();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                dept.setDno(rst.getInt("dno"));
                dept.setDname(rst.getString("dname"));
                dept.setDtype(rst.getString("dtype"));
                dept.setDcost(rst.getDouble("dcost"));
                dept.setDinsurance(rst.getDouble("dinsurance"));
                dept.setNumber(rst.getInt("number"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
    

}
