/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Department;
import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;

/**
 *
 * @author 98530
 */
public class DepartmentDao {

    public List<Department> selectDepartment() {
        List<Department> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from dept";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Department dept = new Department();
                dept.setDno(rst.getInt("dno"));
                dept.setDname(rst.getString("dname"));
                dept.setDtype(rst.getString("dtype"));
                dept.setDcost(rst.getDouble("dcost"));
                dept.setDinsurance(rst.getDouble("dinsurance"));
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

    public boolean addDepartment(Department dept) {
        String sql = "INSERT INTO dept (dno,dname,dtype,dcost,dinsurance) VALUES(?,?,?,?,?);";
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

    public boolean updateDepartment(Department dept) {
        String sql = "UPDATE dept set dname=?,dtype=?,dcost=?,dinsurance=? WHERE dno=?";
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

    public boolean updateDepartmentCost(double cost, int dno) {
        String sql = "UPDATE dept set dcost=? WHERE dno=?";
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

    public List<Employee> getDeptMember(int dno) {
        List<Employee> employeeList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from employees where dno =" + dno;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {

                Employee ep = new Employee();
                ep.setEno(rst.getInt("eno"));
                ep.setEname(rst.getString("ename"));
                ep.setEsal(rst.getDouble("esal"));
                ep.setEsex(rst.getString("esex"));
                ep.setEage(rst.getInt("eage"));
                ep.setEtel(rst.getInt("etel"));
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
        String sql = "select count(*) from dept where dno =" + dno;
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

    public boolean deleteDepartment(int dno) {
        String sql = "delete from dept where dno = ?";
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

    public Department getDepartmentById(int dno) {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from dept where dno =" + dno;
        Department dept = new Department();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                dept.setDno(rst.getInt("dno"));
                dept.setDname(rst.getString("dname"));
                dept.setDtype(rst.getString("dtype"));
                dept.setDcost(rst.getDouble("dcost"));
                dept.setDinsurance(rst.getDouble("dinsurance"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
