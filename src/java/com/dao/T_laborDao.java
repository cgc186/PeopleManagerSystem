/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.T_labor;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_laborDao {
    public List<T_labor> getLaborList(){
        String sql = "select * from t_labor";
        return DH.getall(sql, new T_labor(), new String[]{});
    }
    
    
}
