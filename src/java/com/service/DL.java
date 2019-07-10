/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.pojo.T_user;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 98530
 */
public class DL {

    private DL() {
        this.userol = new Vector<T_userEcho>();
    }

    private static DL d;

    public static synchronized DL getdl() {
        if (d == null) {
            d = new DL();
        }
        return d;
    }

    private Vector<T_userEcho> userol;

    public synchronized void adduser(T_userEcho te) {
        this.userol.add(te);
    }

    public boolean checkuser(String uname, String upwd) {
        Boolean b = false;
        for (int i = 0; i < this.userol.size(); i++) {
            T_userEcho te = this.userol.get(i);
            T_user u = te.getU();
            if(u.getUsername().equals(uname)&&u.getPassword().equals(upwd)){
                b = true;
                break;
            }
        }
        return b;
    }
    
    public void sendmessage(String msg){
        for (int i = 0; i < this.userol.size(); i++) {
            T_userEcho te = this.userol.get(i);
            try {
                te.getSession().getBasicRemote().sendText(msg);
            } catch (IOException ex) {
                continue;
            }
        }
    }
}
