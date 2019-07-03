/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_employee;
import com.pojo.T_menu;
import com.pojo.T_transfer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.util.DbUtil;
import com.service.EventService;

/**
 *
 * @author 98530
 */
public class T_employeesDao {

    public List<T_employee> getListByDeptId(int dno) {
        String sql = "select * from t_employees where dno = ?";
        return DH.getall(sql, new T_employee(), new String[]{String.valueOf(dno)});
    }

    public List<T_employee> selectEmployee(boolean isQuit) {
        List<T_employee> employeeList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql;
        if (!isQuit) {
            sql = "select * from t_employees";
        } else {
            sql = "select * from t_employees_off";
        }

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
                ep.setEtel(rst.getInt("etel"));
                ep.setEnational(rst.getString("enational"));
                ep.setEtype(rst.getString("etype"));
                if (!isQuit) {
                    ep.setEin_date(rst.getDate("ein_date"));
                } else {
                    ep.setEout_date(rst.getDate("eout_date"));
                }
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

    public boolean addEmployee(T_employee ep, boolean isQuit) {
        String sql;
        if (!isQuit) {
            sql = "INSERT INTO t_employees (ename,esal,esex,eage,etel,enational,etype,ein_date,eculture,dno) VALUES(?,?,?,?,?,?,?,?,?,?);";
        } else {
            sql = "INSERT INTO t_employees_off (ename,esal,esex,eage,etel,enational,etype,eout_date,eculture,dno) VALUES(?,?,?,?,?,?,?,?,?,?);";
        }

        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            EventService eu = new EventService();

            pst.setString(1, ep.getEname());
            pst.setDouble(2, ep.getEsal());
            pst.setString(3, ep.getEsex());
            pst.setInt(4, ep.getEage());
            pst.setInt(5, ep.getEtel());
            pst.setString(6, ep.getEnational());
            pst.setString(7, ep.getEtype());
            if (!isQuit) {
                pst.setDate(8, ep.getEin_date());

                eu.EmployeesAddEvent(ep);
            } else {
                pst.setDate(8, ep.getEout_date());

                eu.EmployeesLeftEvent(ep);
            }
            pst.setString(9, ep.getEculture());
            pst.setInt(10, ep.getDno());
            int count = pst.executeUpdate();
            pst.close();

            System.out.println(sql);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addEmployeeList(List<T_employee> el, boolean isQuit) {
        for (T_employee e : el) {
            addEmployee(e, isQuit);
        }
    }

    public boolean updateEmployee(T_employee ep, boolean isQuit) {
        String sql;
        if (!isQuit) {
            sql = "UPDATE t_employees set ename=?,esal=?,esex=?,eage=?,etel=?,enational=?,etype=?,ein_date=?,eculture=?,dno=? WHERE  eno=?";
        } else {
            sql = "UPDATE t_employees_off set ename=?,esal=?,esex=?,eage=?,etel=?,enational=?,etype=?,eout_date=?,eculture=?,dno=? WHERE  eno=?";
        }
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ep.getEname());
            pst.setDouble(2, ep.getEsal());
            pst.setString(3, ep.getEsex());
            pst.setInt(4, ep.getEage());
            pst.setInt(5, ep.getEtel());
            pst.setString(6, ep.getEnational());
            pst.setString(7, ep.getEtype());
            if (!isQuit) {
                pst.setDate(8, ep.getEin_date());
            } else {
                pst.setDate(8, ep.getEout_date());
            }
            pst.setString(9, ep.getEculture());
            pst.setInt(10, ep.getDno());
            pst.setInt(11, ep.getEno());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmployeeDept(int eno, boolean isQuit, int dno) {
        String sql;
        if (!isQuit) {
            sql = "UPDATE t_employees set dno=? WHERE  eno=?";
        } else {
            sql = "UPDATE t_employees_off set dno=? WHERE  eno=?";
        }
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, dno);
            pst.setInt(2, eno);

            int prevdno = getEmployeeDeptById(eno, false);

            T_transfer t = new T_transfer();

            t.setCurrdept(dno);
            t.setPrevdept(prevdno);
            t.setEno(eno);
            Date date = new Date();
            java.sql.Date time = new java.sql.Date(date.getTime());
            t.setTime(time);

            TransferDao td = new TransferDao();
            td.addRecords(t);

            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(int eno, boolean isQuit) {
        String sql;
        if (!isQuit) {
            sql = "delete from t_employees where eno = ?";
        } else {
            sql = "delete from t_employees_off where eno = ?";
        }
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, eno);

            EventService eu = new EventService();
            if (!isQuit) {
                T_employee e = getEmployeeById(eno, false);
                eu.EmployeesLeftEvent(e);
                addEmployee(e, true);
            }

            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public T_employee getEmployeeById(int eno, boolean isQuit) {
        Connection conn = DbUtil.getConnection();

        String sql;
        if (!isQuit) {
            sql = "select * from t_employees where eno =" + eno;
        } else {
            sql = "select * from t_employees_off where eno =" + eno;
        }
        T_employee ep = new T_employee();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                ep.setEno(eno);
                ep.setEname(rst.getString("ename"));
                ep.setEsal(rst.getDouble("esal"));
                ep.setEsex(rst.getString("esex"));
                ep.setEage(rst.getInt("eage"));
                ep.setEtel(rst.getInt("etel"));
                ep.setEnational(rst.getString("enational"));
                ep.setEtype(rst.getString("etype"));
                if (!isQuit) {
                    ep.setEin_date(rst.getDate("ein_date"));
                } else {
                    ep.setEout_date(rst.getDate("eout_date"));
                }
                ep.setEculture(rst.getString("eculture"));
                ep.setDno(rst.getInt("dno"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ep;
    }

    public int getEmployeeDeptById(int eno, boolean isQuit) {
        Connection conn = DbUtil.getConnection();

        String sql;
        if (!isQuit) {
            sql = "select dno from t_employees where eno =" + eno;
        } else {
            sql = "select dno from t_employees_off where eno =" + eno;
        }
        int dno = 0;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                dno = rst.getInt("dno");
            }
            rst.close();
            pst.close();
            conn.close();
            return dno;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dno;
    }
}
