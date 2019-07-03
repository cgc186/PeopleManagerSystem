/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_userDao;
import com.pojo.T_user;

/**
 *
 * @author 98530
 */
public class T_userService {

    private T_userDao ud = new T_userDao();

    public String login(String uname, String upwd) {
        T_user ul = ud.login(uname, upwd);
        if (ul == null) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }
}
