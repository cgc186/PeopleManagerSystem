/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_userDao;
import com.pojo.T_user;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_userService {

    private T_userDao ud = new T_userDao();

    public String login(String uname, String upwd) {
        DL d = DL.getdl();
        boolean b = d.checkuser(uname, upwd);
        if (b == true) {
            return "{\"msg\":\"input\"}";
        }
        T_user ul = ud.existence(uname, upwd);
        if (ul == null) {
            return "{\"msg\":\"error\"}";
        } else {
            return ul.toString();
        }
    }

    public List<T_user> getList() {
        return ud.getUserList();
    }

    public boolean updateUser(int id, String uname, String upwd) {
        T_user u = new T_user();
        u.setUserid(id);
        u.setUsername(uname);
        u.setPassword(upwd);
        return ud.updateUserPwd(u);
    }

    /*
    注册
     */
    public String reg(String uname, String upwd) {
        T_user ul = ud.existence(uname, upwd);
        if (ul == null) {
            T_user u = new T_user();
            u.setUsername(uname);
            u.setPassword(upwd);
            boolean b = ud.addUser(u);
            if (b) {
                return "{\"msg\":\"success\"}";
            } else {
                return "{\"msg\":\"error\"}";
            }
        } else {
            return "{\"msg\":\"input\"}";
        }
    }

    public String getuserlist() {
        List<T_user> u1 = null;
        u1 = ud.getUserList();
        if (u1.isEmpty()) {
            return "{\"msg\":\"error\"}";
        } else {
            String s = "[";
            for (T_user u : u1) {
                s += u.toString() + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "]";
            return s;
        }
    }
}
