/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Transfer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.DbUtil;
import util.EventUtil;

/**
 *
 * @author 98530
 */
public class TransferDao {

    public boolean addRecords(Transfer t) {
        String sql = "INSERT INTO transfer (eno,prevdept,currdept,time) VALUES(?,?,?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, t.getEno());
            pst.setInt(2, t.getPrevdept());
            pst.setInt(3, t.getCurrdept());
            pst.setDate(4, t.getTime());
            int count = pst.executeUpdate();
            pst.close();
            EventUtil eu = new EventUtil();
            eu.EmployeesTransferEvent(t);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
