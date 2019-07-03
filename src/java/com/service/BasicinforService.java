/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.BasicInformationDao;
import com.dao.T_employeesDao;
import java.util.List;

/**
 *
 * @author zhang
 */
public class BasicinforService {
    private BasicInformationDao b = new BasicInformationDao();
    public List<String> getList(String type) {
        return b.getList(type);
    }
    public boolean addType(String type, String name) {
        return b.addType(type, name);
    }
    
}
