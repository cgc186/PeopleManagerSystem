/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_menuDao;
import com.dao.T_roleDao;
import com.dao.T_userDao;
import com.pojo.T_menu;
import com.pojo.T_role;
import com.pojo.T_user;
import java.util.List;

/**
 *
 * @author zhang
 */
public class T_roleService {

    private T_roleDao rd = new T_roleDao();
    private T_menuDao td = new T_menuDao();
    private T_userDao tu = new T_userDao();

    public String Role_list() {
        List<T_role> rolelist = rd.getRoleList();
        String list = "[";
        for (int i = 0; i < rolelist.size(); i++) {
            list += rolelist.get(i).toString() + ",";
        }
        if (rolelist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }

    public String getByRid(int rid) {
        List<T_menu> menulist = td.getByRid(rid);
        String list = "[";
        for (int i = 0; i < menulist.size(); i++) {
            list += menulist.get(i).toString() + ",";
        }
        if (menulist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }

    public String addrole(T_role role) {
        Boolean u1 = rd.addRole(role);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String deleteRole(int rid) {
        boolean flag = rd.deleterole(rid);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }
    public String getUserlist(int rid){
        List<T_user> userlist = tu.getUserListbyRid(rid);
        String list = "[";
        for (int i = 0; i < userlist.size(); i++) {
            list += userlist.get(i).toString() + ",";
        }
        if (userlist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }
}
