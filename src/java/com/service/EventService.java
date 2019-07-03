/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_eventDao;
import com.pojo.T_employee;
import com.pojo.T_event;
import com.pojo.T_transfer;
import java.util.Date;

/**
 *
 * @author 98530
 */
public class EventService {

    private void AddEvent(String content) {
        T_eventDao ed = new T_eventDao();
        T_event e = new T_event();

        java.sql.Date time = new java.sql.Date(new Date().getTime());
        e.setTime(time);

        e.setContent(content);
        ed.addEvent(e);
    }

    public void EmployeesAddEvent(T_employee ee) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname()
                + "入职,进入的部门编号为" + ee.getDno();
        AddEvent(content);
    }

    public void EmployeesLeftEvent(T_employee ee) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname() + "离职";
        AddEvent(content);
    }

    public void EmployeesTransferEvent(T_transfer t) {
        String content = null;
        content = "编号为" + t.getEno() + "的员工从"
                + t.getPrevdept() + "调到了" + t.getCurrdept() + "部门";
        AddEvent(content);
    }
}
