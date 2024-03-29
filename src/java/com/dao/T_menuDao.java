/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_menu;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_menuDao {
    
    public List<T_menu> getByUid(int uid) {
        String sql = "select * from t_menu where id in ("
                + "select mid from t_rm where rid in("
                + "select rid from t_ur where uid =?))";
        return DH.getall(sql, new T_menu(), new String[]{String.valueOf(uid)});
    }

    public List<T_menu> getByMid(int uid,int mid) {
        String sql = "select * from t_menu where father = ? and id in ("
                + "select mid from t_rm where rid in("
                + "select rid from t_ur where uid =?))";
        return DH.getall(sql, new T_menu(), new String[]{String.valueOf(mid),String.valueOf(uid)});
    }
    public List<T_menu> getByRid(int rid) {
        String sql = "select * from t_menu where id in ("
                + "select mid from t_rm where rid=?)";
        return DH.getall(sql, new T_menu(), new String[]{String.valueOf(rid)});
    }
    public List<T_menu>getMenu(){
        String sql="select * from t_menu";
        return DH.getall(sql, new T_menu(), new String[]{});
    }
}
