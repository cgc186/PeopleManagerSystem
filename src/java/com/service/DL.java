/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.Vector;

/**
 *
 * @author 98530
 */
public class DL {
    private DL(){
        this.userol=new Vector<T_userEcho>();
    }
    
    private static DL d;
    
    public static synchronized DL getdl(){
        if(d==null){
            d=new DL();
        }
        return d;
    }
    
    private Vector<T_userEcho> userol;
}
