/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_user;
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
public class T_userDao {

    public boolean addUser(T_user user) {
        String sql = "INSERT INTO t_user (username,password) VALUES(?,?);";
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

    public List<T_user> getUserList() {
        List<T_user> adminList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_user";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_user admin = new T_user();
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

    public boolean updateUserPwd(T_user user) {
        String sql = "UPDATE t_user set username=?,password=? WHERE userid=?";
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

    public T_user getUserById(int userid) {
        String sql = "SELECT * FROM t_user WHERE userid = ? LIMIT 1";
        Connection conn = DbUtil.getConnection();
        ResultSet rst = null;
        T_user user = new T_user();
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

    public T_user getUserByUname(String username) {
        String sql = "SELECT * FROM t_user WHERE username = ? LIMIT 1";
        Connection conn = DbUtil.getConnection();
        ResultSet rst = null;
        T_user user = new T_user();
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
            e.printStackTrace();
        }
        return null;
    }

    public T_user existence(String uname, String upwd) {
        String sql = "select * from t_user where username = ? and password = ?";
        Connection conn = DbUtil.getConnection();
        ResultSet rst = null;
        T_user user = null;
//        user.setEmpty(true);
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, uname);
            pst.setString(2, upwd);
            rst = pst.executeQuery();
//            if (rst.next()) {
//                user.setSessionid(rst.getString("sessionid"));
//                if ("".equals(user.getSessionid())||user.getSessionid()==null) {
//                    String sql_id = "update t_user set sessionid=? where username = ?";
//                    DH.update(sql_id, new String[]{sessionid, uname});
//                } else if (!user.getSessionid().equals(sessionid)) {
//                    return null;
//                }
//            }
            if (rst.next()) {
                user = new T_user();
                user.setUsername(uname);
                user.setPassword(upwd);
                user.setUserid(rst.getInt("userid"));
                user.setRealname(rst.getString("realname"));
            }
            rst.close();
            pst.close();
            conn.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T_user> getUserListbyRid(int rid) {
        List<T_user> adminList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_user where userid in(select uid from t_ur where rid=?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, rid);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_user admin = new T_user();
                admin.setUserid(rst.getInt("userid"));
                admin.setUsername(rst.getString("username"));
                admin.setPassword(rst.getString("password"));
                admin.setRealname(rst.getString("realname"));;
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
}
