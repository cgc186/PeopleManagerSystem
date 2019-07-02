/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.sql.Date;

/**
 *
 * @author 98530
 */
public class T_employee {

    private int eno;
    private String ename;
    private double esal;
    private String esex;
    private int eage;
    private int etel;
    private String enational;
    private String etype;
    private Date ein_date;
    private Date eout_date;
    private String eculture;
    private int dno;

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }

    public int getEtel() {
        return etel;
    }

    public void setEtel(int etel) {
        this.etel = etel;
    }

    public String getEnational() {
        return enational;
    }

    public void setEnational(String enational) {
        this.enational = enational;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public Date getEin_date() {
        return ein_date;
    }

    public void setEin_date(Date ein_date) {
        this.ein_date = ein_date;
    }

    public Date getEout_date() {
        return eout_date;
    }

    public void setEout_date(Date eout_date) {
        this.eout_date = eout_date;
    }

    public String getEculture() {
        return eculture;
    }

    public void setEculture(String eculture) {
        this.eculture = eculture;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

}
