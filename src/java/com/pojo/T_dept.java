/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author 98530
 */
public class T_dept {

    private int dno;
    private String dname;
    private String dtype;
    private double dcost;
    private double dinsurance;
    private int father;
    private int number;

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public double getDcost() {
        return dcost;
    }

    public void setDcost(double dcost) {
        this.dcost = dcost;
    }

    public double getDinsurance() {
        return dinsurance;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public void setDinsurance(double dinsurance) {
        this.dinsurance = dinsurance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String s = "{\"dno\":\"" + this.dno + "\","
                + "\"dname\":\"" + this.dname + "\","
                + "\"dtype\":\"" + this.dtype + "\","
                + "\"dcost\":\"" + this.dcost + "\","
                + "\"dinsurance\":\"" + this.dinsurance + "\","
                + "\"father\":\"" + this.father + "\","
                + "\"number\":\"" + this.number + "\"}";
        return s;
    }

}
