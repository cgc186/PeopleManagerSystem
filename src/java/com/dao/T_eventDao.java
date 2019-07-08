/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.util.DbUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_eventDao {

    public boolean addEvent(T_event et) {
        String sql = "INSERT INTO t_event (time,content,type,operator) VALUES(?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, et.getTime());
            pst.setString(2, et.getContent());
            pst.setString(3,et.getType());
            pst.setInt(4,et.getOperator());
            int count = pst.executeUpdate();
            pst.close();
            System.out.println(sql);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<T_event> getEventList(){
        String sql = "select * from t_event";
        return DH.getall(sql, new T_event(), new String[]{});
    }

    /*
    获得时间段内的事件
     */
    public List<T_event> getEventsOverTime(Date d1, Date d2) {
        List<T_event> el = new ArrayList();
        java.sql.Date dd1 = new java.sql.Date(d1.getTime());
        java.sql.Date dd2 = new java.sql.Date(d2.getTime());
        String sql = "select * from t_event where time >= ? and time <= ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, dd1);
            pst.setDate(2, dd2);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_event e = new T_event();
                e.setTime(rst.getDate("time"));
                e.setContent(rst.getString("content"));
                e.setType(rst.getString("type"));
                e.setOperator(rst.getInt("operator"));
                el.add(e);
            }
            rst.close();
            pst.close();
            return el;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return el;
    }
}
