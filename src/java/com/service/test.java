/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_eventDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 98530
 */
public class test {
    public static void main(String args[]){
        T_eventDao ed = new T_eventDao();
        List<Date> timelist = ed.getTime();
        List<String> typelist = ed.getType();
        
        for (Date date : timelist) {
            System.out.println(date);
        }
        
        for (String s : typelist) {
            System.out.println(s);
        }
    }
}
