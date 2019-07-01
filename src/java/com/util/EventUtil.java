/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.dao.EventDao;
import com.entity.Employee;
import com.entity.Event;
import com.entity.Transfer;
import java.util.Date;

/**
 *
 * @author 98530
 */
public class EventUtil {

    private void AddEvent(String content) {
        EventDao ed = new EventDao();
        Event e = new Event();

        java.sql.Date time = new java.sql.Date(new Date().getTime());
        e.setTime(time);

        e.setContent(content);
        ed.addEvent(e);
    }

    public void EmployeesAddEvent(Employee ee) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname()
                + "入职,进入的部门编号为" + ee.getDno();
        AddEvent(content);
    }

    public void EmployeesLeftEvent(Employee ee) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname() + "离职";
        AddEvent(content);
    }

    public void EmployeesTransferEvent(Transfer t) {
        String content = null;
        content = "编号为" + t.getEno() + "的员工从"
                + t.getPrevdept() + "调到了" + t.getCurrdept() + "部门";
        AddEvent(content);
    }
}
