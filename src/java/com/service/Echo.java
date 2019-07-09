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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class Echo {

    @OnOpen
    public void abcd1(Session session) {
        System.out.println("连接成功");
    }

    @OnClose
    public void abcd2() {

    }

    @OnError
    public void abcd3(Throwable error) {

    }

    @OnMessage
    public void abcd4(Session session, String message) {
        System.out.println(message);
        try {
            session.getBasicRemote().sendText("收到了!");
        } catch (IOException ex) {
            Logger.getLogger(Echo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}