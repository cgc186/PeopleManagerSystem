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
public class T_security {

    private int id;
    private String name;
    private int eno;
    private String number;
    private String state;
    private Date starttime;
    private Date endtime;
    private double mouth;
    private double esal;

    @Override
    public String toString() {
        String s = "{\"id\":\"" + this.id + "\","
                + "\"name\":\"" + this.name + "\","
                + "\"eno\":\"" + this.eno + "\","
                + "\"number\":\"" + this.number + "\","
                + "\"state\":\"" + this.state + "\","
                + "\"starttime\":\"" + this.starttime + "\","
                + "\"endtime\":\"" + this.endtime + "\","
                + "\"mouth\":\"" + this.mouth + "\","
                + "\"esal\":\"" + this.esal + "\"}";
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public double getMouth() {
        return mouth;
    }

    public void setMouth(double mouth) {
        this.mouth = mouth;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

}
