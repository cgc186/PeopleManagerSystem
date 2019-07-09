/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.pojo.T_user;
import javax.websocket.Session;

/**
 *
 * @author 98530
 */
public class T_userEcho {
    private T_user u;
    private Session session;
    

    public T_user getU() {
        return u;
    }

    public void setU(T_user u) {
        this.u = u;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
}
