/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.sql.Date;

/**
 *
 * @author 98530
 */
public class T_event {

    private Date time;
    private String content;
    private String type;
    private int operator;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        String s = "{\"time\":\"" + this.time + "\","
                + "\"content\":\"" + this.content + "\","
                + "\"type\":\"" + this.type + "\","
                + "\"operator\":\"" + this.operator + "\"}";
        return s;
    }
}
