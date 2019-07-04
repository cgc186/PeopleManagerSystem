/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_userDao;
import com.pojo.T_user;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_userService {

    private T_userDao ud = new T_userDao();

    public String login(String uname, String upwd,String sessionid){
        T_user ul = ud.existence(uname, upwd,sessionid);
        if (ul == null) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }
    
    public List<T_user> getList(){
        return ud.getUserList();
    }
    
    public boolean updateUser(int id,String uname,String upwd){
        T_user u = new T_user();
        u.setUserid(id);
        u.setUsername(uname);
        u.setPassword(upwd);
        return ud.updateUserPwd(u);
    }
    
    /*
    注册
    */
    public boolean reg(String uname,String upwd){
        String sessionid="";
        T_user ul = ud.existence(uname, upwd,sessionid);
        if (ul == null) {
            T_user u = new T_user();
            u.setUsername(uname);
            u.setPassword(upwd);
            return ud.addUser(ul);
        } else {
            return false;
        }
    }
}
