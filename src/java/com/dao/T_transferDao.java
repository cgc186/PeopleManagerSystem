/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_transfer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.util.DbUtil;
import com.service.EventService;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_transferDao {

    public List<T_transfer> getList() {
        String sql = "select * from t_transfer";
        return DH.getall(sql, new T_transfer(), new String[]{});
    }

    public boolean addRecords(T_transfer t, int uid) {
        String sql = "INSERT INTO t_transfer (eno,prevdept,currdept,time) VALUES(?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, t.getEno());
            pst.setInt(2, t.getPrevdept());
            pst.setInt(3, t.getCurrdept());
            pst.setDate(4, t.getTime());
            int count = pst.executeUpdate();
            pst.close();
            EventService eu = new EventService();
            eu.EmployeesTransferEvent(t, uid);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
