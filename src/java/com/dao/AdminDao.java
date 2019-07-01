/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.util.DbUtil;

/**
 *
 * @author 98530
 */
public class AdminDao {

    public boolean addAdmin(Admin user) {
        String sql = "INSERT INTO admin (username,password) VALUES(?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            int count = pst.executeUpdate();
            pst.close();

            System.out.println(sql);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Admin> selectAdmin() {
        List<Admin> adminList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from admin";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Admin admin = new Admin();
                admin.setUserid(rst.getInt("userid"));
                admin.setUsername(rst.getString("username"));
                admin.setPassword(rst.getString("password"));;
                adminList.add(admin);
            }
            rst.close();
            pst.close();
            return adminList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    public boolean updateAdminPassword(Admin user) {
        String sql = "UPDATE admin set username=?,password=? WHERE userid=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setInt(3, user.getUserid());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Admin findUserByUserid(int userid) {
        String sql = "SELECT * FROM admin WHERE userid = ? LIMIT 1";
        Connection conn = DbUtil.getConnection();
        ResultSet rst = null;
        Admin user = new Admin();
        user.setEmpty(true);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userid);
            rst = pst.executeQuery();
            if (rst.next()) {
                user.setUserid(userid);
                user.setUsername(rst.getString("username"));
                user.setPassword(rst.getString("password"));
                user.setEmpty(false);
            }
            rst.close();
            pst.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Admin findUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM admin WHERE username = ? LIMIT 1";
        Connection conn = DbUtil.getConnection();
        ResultSet rst = null;
        Admin user = new Admin();
        user.setEmpty(true);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rst = pst.executeQuery();
            if (rst.next()) {
                user.setUserid(rst.getInt("userid"));
                user.setUsername(username);
                user.setPassword(rst.getString("password"));
                user.setEmpty(false);
            }
            rst.close();
            pst.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            throw e;
        }
    }
}
