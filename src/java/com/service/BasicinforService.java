/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.BasicInformationDao;
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
}
