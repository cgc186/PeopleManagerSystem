/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_basic;
import com.pojo.T_categories;
import com.pojo.T_employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.util.DbUtil;

/**
 *
 * @author 98530
 */
public class T_basicInformationDao {

    //添加学历或民族 type culture/national
    public boolean addType(String type, String name) {
        String sql = "INSERT INTO t_" + type + " (name,number) VALUES(?,?);";
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
        String sql = "select * from t_" + type;
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
        list.forEach((name) -> {
            es.put(name, new Integer(0));
        });
        T_employeesDao ed = new T_employeesDao();
        List<T_employee> el = ed.selectEmployee(false);
        if (type.equals("culture")) {
            el.forEach((e) -> {
                Integer t = es.get(e.getEculture());
                if (t != null) {
                    t++;
                    es.replace(e.getEculture(), t);
                }
            });
        } else if (type.equals("national")) {
            el.forEach((e) -> {
                Integer t = es.get(e.getEnational());
                if (t != null) {
                    t++;
                    es.replace(e.getEnational(), t);
                }
            });
        }
        return es;
    }

    //学历或民族人数更新 type culture/national
    public void updateData(String type) {
        Map<String, Integer> statistics = getStatistics(type);

        String sql = "UPDATE t_" + type + " set number=? WHERE name=?";
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
    public List<T_basic> getCurrStatistics(String type) {
        List<T_basic> es = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_" + type;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_basic b = new T_basic();
                b.setName(rst.getString(1));
                b.setNumber(rst.getInt(2));
                es.add(b);
            }
            pst.close();
            return es;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return es;
    }

    //type id/jobTitle
    public T_categories selectCategories(String type, String cc) {
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_categories where " + type + " = ?";
        T_categories c = new T_categories();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if (type.equals("id")) {
                pst.setInt(1, Integer.parseInt(cc));
            } else {
                pst.setString(1, cc);
            }
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                c.setJobTitle(rst.getString("jobTitle"));
                c.setId(rst.getInt("id"));
                c.setPostAllowance(rst.getDouble("postAllowance"));
            }
            rst.close();
            pst.close();
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<T_categories> getCategoriesList() {
        List<T_categories> cs = new ArrayList<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from t_categories";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                T_categories c = new T_categories();
                c.setId(rst.getInt("id"));
                c.setJobTitle(rst.getString("jobTitle"));
                c.setPostAllowance(rst.getDouble("postAllowance"));
                cs.add(c);
            }
            pst.close();
            return cs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }

    //添加职务
    public boolean addCategories(T_categories c) {
        String sql = "INSERT INTO t_categories (jobTitle,postAllowance) VALUES(?,?);";
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
    public boolean updateCategories(T_categories c) {
        String sql = "UPDATE t_categories set jobTitle=?,postAllowance=? WHERE id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, c.getJobTitle());
            pst.setDouble(2, c.getPostAllowance());
            pst.setInt(3, c.getId());

            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCategories(int id) {
        String sql = "delete from t_categories where id = ?";
        Connection conn = DbUtil.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int count = pst.executeUpdate();
            pst.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getPostAllowance(String type) {
        String sql = "select postAllowance from t_categories where jobTitle = ?";
        Connection conn = DbUtil.getConnection();
        double pa = 0;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, type);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                pa = rst.getDouble("postAllowance");
            }
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(pa);
    }
}
