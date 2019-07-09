/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_role;
import com.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhang
 */
public class T_roleDao {

    public List<T_role> getRoleList() {
        List<T_role> roleList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_role";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_role role = new T_role();
                role.setId(rst.getInt("id"));
                role.setRolename(rst.getString("rolename"));
                roleList.add(role);
            }
            rst.close();
            pst.close();
            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }
    
    public boolean addRole(T_role role) {
        String sql = "INSERT INTO t_role (id,rolename) VALUES(?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, role.getId());
            pst.setString(2, role.getRolename());
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleterole(int rid) {
        String sql;

        sql = "delete from t_role where id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, rid);

            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleterolemenu(int rid,int mid) {
        String sql;

        sql = "delete from t_rm where rid = ? and mid = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, rid);
            pst.setInt(2, mid);

            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean insertRolemenu(int rid,int mid) {
        String sql;

        sql = "insert into t_rm(rid,mid) values (?,?)";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, rid);
            pst.setInt(2, mid);

            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
