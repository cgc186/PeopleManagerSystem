/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_labor;
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

    public Date getTime(int id) {
        String sql = "select * from t_labor where id = ?";
        List<T_labor> ll = DH.getall(sql, new T_labor(), new String[]{String.valueOf(id)});
        T_labor l = ll.get(0);
        Date date = new Date(l.getEndtime().getTime());
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
