/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Basic;
import entity.Categories;
import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import util.DbUtil;

/**
 *
 * @author 98530
 */
public class BasicInformationDao {

    //添加学历或民族 type culture/national
    public boolean addType(String type, String name) {
        String sql = "INSERT INTO " + type + " (name,number) VALUES(?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, 0);
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //得到学历或民族列表 type culture/national
    public List<String> getList(String type) {
        List<String> deptList = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from " + type;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                deptList.add(rst.getString(1));
            }
            rst.close();
            pst.close();
            return deptList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }

    //String degree[]={"小学","初中","高中","技工","中专","大专","本科","研究生"};
    //学历或民族统计 type culture/national
    public Map<String, Integer> getStatistics(String type) {
        Map<String, Integer> es = new HashMap<>();
        List<String> list = getList(type);
        for (String string : list) {
            es.put(string, 0);
        }
        EmployeesDao ed = new EmployeesDao();
        List<Employee> el = ed.selectEmployee(false);
        for (Employee e : el) {
            Integer t = es.get(e.getEculture());
            t++;
            es.replace(e.getEculture(), t);
        }
        return es;
    }

    //学历或民族人数更新 type culture/national
    public void updateDate(String type) {
        Map<String, Integer> statistics = getStatistics(type);

        String sql = "UPDATE " + type + " set number=? WHERE name=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for (Entry<String, Integer> entry : statistics.entrySet()) {
                pst.setInt(1, entry.getValue());
                pst.setString(2, entry.getKey());
                pst.executeUpdate();
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获得当前数据库学历或民族统计 type culture/national
//    public Map<String, Integer> getCurrStatistics(String type) {
//        Map<String, Integer> es = new HashMap<>();
//        Connection conn = DbUtil.getConnection();
//        String sql = "select * from " + type;
//        try {
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rst = pst.executeQuery();
//            while (rst.next()) {
//                es.put(rst.getString("name"), rst.getInt("number"));
//            }
//            pst.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return es;
//    }
    //获得当前数据库学历或民族统计 type culture/national
    public List<Basic> getCurrStatistics(String type) {
        List<Basic> es = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from " + type;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Basic b = new Basic();
                b.setName(rst.getString(1));
                b.setNumber(rst.getInt(2));
                es.add(b);
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return es;
    }

    //添加职务
    public boolean addCategories(Categories c) {
        String sql = "INSERT INTO categories (JobTitle,PostAllowance) VALUES(?,?);";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, c.getJobTitle());
            pst.setDouble(2, c.getPostAllowance());
            int count = pst.executeUpdate();
            pst.close();

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //修改职务对应的岗位津贴
    public boolean updateCategories(Categories c) {
        String sql = "UPDATE categories set PostAllowance=? WHERE JobTitle=?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDouble(1,c.getPostAllowance());
            pst.setString(2, c.getJobTitle());
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
