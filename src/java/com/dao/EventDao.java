/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.util.DbUtil;

/**
 *
 * @author 98530
 */
public class EventDao {

    public boolean addEvent(Event et) {
        String sql = "INSERT INTO event (time,content) VALUES(?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, et.getTime());
            pst.setString(2, et.getContent());
            int count = pst.executeUpdate();
            pst.close();
            System.out.println(sql);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    获得时间段内的时间
     */
    public Map<Date, String> getEventsOverTime(Date d1, Date d2) {
        Map<Date, String> el = new HashMap<>();
        java.sql.Date dd1 = new java.sql.Date(d1.getTime());
        java.sql.Date dd2 = new java.sql.Date(d2.getTime());
        String sql = "select * from event where time >= ? and time <= ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, dd1);
            pst.setDate(2, dd2);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                el.put(rst.getDate("time"), rst.getString("content"));
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
