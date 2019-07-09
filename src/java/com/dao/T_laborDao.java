/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_labor;
import com.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_laborDao {

    public List<T_labor> getLaborList() {
        String sql = "select * from t_labor";
        return DH.getall(sql, new T_labor(), new String[]{});
    }

    public boolean addLabor(T_labor l) {
        String sql = "INSERT INTO t_labor (eno,category,dno,startTime,signingTime,msal,endtime) VALUES(?,?,?,?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, l.getEno());
            pst.setString(2, l.getCategory());
            pst.setInt(3, l.getDno());
            pst.setDate(4, l.getStartTime());
            pst.setDate(5, l.getSigningTime());
            pst.setDouble(6, l.getMsal());
            pst.setDate(7, l.getEndTime());
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<T_labor> selectByEno(int eno){
        String sql = "select * from t_labor where eno = ?";
        return DH.getall(sql, new T_labor(), new String[]{String.valueOf(eno)});
    }

    public Date getTime(int id) {
        String sql = "select * from t_labor where id = ?";
        List<T_labor> ll = DH.getall(sql, new T_labor(), new String[]{String.valueOf(id)});
        T_labor l = ll.get(0);
        Date date = new Date(l.getEndTime().getTime());
        return date;
    }

    public int update(int id, int time) {
        String sql = "update t_labor set endtime = ?,renewalTime = ? where id = ?";

        Date endtime = getTime(id);
        Calendar cal = Calendar.getInstance();
        cal.setTime(endtime);
        cal.add(Calendar.YEAR, time);

        Date end = cal.getTime();
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String nowTime = sdf.format(date);
        String eTime = sdf.format(end);
        return DH.update(sql, new String[]{eTime, nowTime, String.valueOf(id)});
    }

    public int Relieve(int id) {
        String sql = "update t_labor set releaseTime = ? where id=?";
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String nowTime = sdf.format(date);

        return DH.update(sql, new String[]{nowTime, String.valueOf(id)});
    }
}
