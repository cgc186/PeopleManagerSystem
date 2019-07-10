/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

/**
 *
 * @author 98530
 */
import com.dao.T_userDao;
import com.pojo.T_user;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo/{uid}")
public class Echo {

    @OnOpen
    public void abcd1(Session session, @PathParam(value = "uid") String uid) {
        System.out.println("连接成功");
        T_userDao td = new T_userDao();
        T_user u = td.getUserById(Integer.parseInt(uid));
        T_userEcho te = new T_userEcho();
        te.setU(u);
        te.setSession(session);
        DL d = DL.getdl();
        d.adduser(te);
    }

    @OnClose
    public void abcd2(@PathParam(value="uid")String uid) {
        System.out.println("close");
        DL d = DL.getdl();
        d.removeuser(uid);
    }

    @OnError
    public void abcd3(Throwable error) {

    }

    @OnMessage
    public void abcd4(Session session, String message) {
        DL d = DL.getdl();
        d.sendmessage(message);
    }

}
