/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_security;
import com.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_securityDao {
    
    public List<T_security> getList() {
        String sql = "select * from t_security";
        return DH.getall(sql, new T_security(), new String[]{});
    }

    public boolean add(T_security s) {
        String sql = "INSERT INTO t_security (id,name,eno,number,state,starttime,endtime,month,esal) VALUES(?,?,?,?,?,?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, s.getId());
            pst.setString(2, s.getName());
            pst.setInt(3, s.getEno());
            pst.setString(4,s.getNumber());
            pst.setString(5,s.getState());
            pst.setDate(6, s.getStarttime());
            pst.setDate(7, s.getEndtime());
            pst.setDouble(8, s.getMonth());
            pst.setDouble(9, s.getEsal());
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
