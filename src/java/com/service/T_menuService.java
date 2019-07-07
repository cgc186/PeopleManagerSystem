/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_menuDao;
import com.pojo.T_menu;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_menuService {

    private T_menuDao md = new T_menuDao();

    public String getByUid(int uid, int mid) {
        List<T_menu> ml = null;
        ml = md.getByMid(uid,mid);
        if (ml.isEmpty()) {
            return "{\"msg\":\"error\"}";
        } else {
            String s = "[";
            for (T_menu m : ml) {
                s += m.toString() + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "]";
            return s;
        }
    }

}
