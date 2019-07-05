/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import com.service.T_menuService;

/**
 *
 * @author 98530
 */
public class test {
    public static void main(String args[]){
        T_menuService ms = new T_menuService();
        String s = ms.getByUid(1);
        System.out.println(s);
    }
}
