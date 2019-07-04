/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_basicInformationDao;
import com.pojo.T_categories;
import java.util.List;

/**
 *
 * @author zhang
 */
public class BasicinforService {

    private T_basicInformationDao bd = new T_basicInformationDao();

    public List<String> getList(String type) {
        return bd.getList(type);
    }

    public String addType(String type, String name) {
        if(name.equals("")||name==null){
            return "{\"msg\":\"error\"}";
        }
        boolean flag = bd.addType(type, name);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String addCategories(String name, double pa) {
        T_categories c = new T_categories();
        c.setJobTitle(name);
        c.setPostAllowance(pa);
        boolean flag = bd.addCategories(c);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public List getCategoriesList() {
        return bd.getCategoriesList();
    }

    public List getCurrStatistics(String type) {
        return bd.getCurrStatistics(type);
    }

    public void updateData(String type) {
        bd.updateData(type);
    }

    public void deleteCategories(int id) {
        bd.deleteCategories(id);
    }

    public void updateCategories(int id,String dname,double pa) {
        T_categories c = new T_categories();
        c.setId(id);
        c.setJobTitle(dname);
        c.setPostAllowance(pa);

        bd.updateCategories(c);
    }
}
