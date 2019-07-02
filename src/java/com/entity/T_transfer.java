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
public class T_transfer {

    private int eno;
    private int prevdept;
    private int currdept;
    private Date time;

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public int getPrevdept() {
        return prevdept;
    }

    public void setPrevdept(int prevdept) {
        this.prevdept = prevdept;
    }

    public int getCurrdept() {
        return currdept;
    }

    public void setCurrdept(int currdept) {
        this.currdept = currdept;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
