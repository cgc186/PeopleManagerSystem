package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 98530
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {

    /**
     * 取得一个数据库连接
     *
     * @return conn
     */
    public static Connection getConnection() {
        try {
            Connection conn = null;
            // 加载数据库驱动类
            /**
             * 这是SqlServer的情形；
             * Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"
             * ).newInstance()
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/employees?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
            // 数据库用户名
            String user = "root";
            // 数据库密码
            String password = "admin";
            // 根据数据库参数取得一个数据库连接
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 根据传入的SQL语句返回一个结果集
     *
     * @param sql
     * @return
     * @throws Exception
     */
    public ResultSet select(String sql) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException sqle) {
            throw new SQLException("select data exception: "
                    + sqle.getMessage());
        } catch (Exception e) {
            throw new Exception("System e exception: " + e.getMessage());
        }
    }

    /**
     * 根据传入的SQL语句向数据库增加一条记录
     *
     * @param sql
     * @throws Exception
     */
    public void insert(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("insert data exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }

    /**
     * 根据传入的SQL语句更新数据库记录
     *
     * @param sql
     * @throws Exception
     */
    public void update(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("update exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }

    /**
     * 根据传入的SQL语句删除一条数据库记录
     *
     * @param sql
     * @throws Exception
     */
    public void delete(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("delete data exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }
}
