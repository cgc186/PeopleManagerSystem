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
public class T_labor {

    private int id;
    private int eno;
    private String category;
    private int dno;
    private Date startTime;
    private Date signingTime;
    private double msal;
    private Date endTime;
    private Date renewalTime;
    private Date releaseTime;

    @Override
    public String toString() {
        String s = "{\"id\":\"" + this.id + "\","
                + "\"eno\":\"" + this.eno + "\","
                + "\"category\":\"" + this.category + "\","
                + "\"dno\":\"" + this.dno + "\","
                + "\"startTime\":\"" + this.startTime + "\","
                + "\"signingTime\":\"" + this.signingTime + "\","
                + "\"msal\":\"" + this.msal + "\","
                + "\"endtime\":\"" + this.endTime + "\","
                + "\"renewalTime\":\"" + this.renewalTime + "\","
                + "\"releaseTime\":\"" + this.releaseTime + "\"}";
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public double getMsal() {
        return msal;
    }

    public void setMsal(double msal) {
        this.msal = msal;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRenewalTime() {
        return renewalTime;
    }

    public void setRenewalTime(Date renewalTime) {
        this.renewalTime = renewalTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    
}
