/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_employeesDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_employee;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zhang
 */
public class EmployService {

    private T_employeesDao ed = new T_employeesDao();

    public String Employ_list(boolean isQuit) {
        List<T_employee> Employeeslist = ed.selectEmployee(isQuit);
        String list = "[";
        for (int i = 0; i < Employeeslist.size(); i++) {
            list += Employeeslist.get(i).toString() + ",";
        }
        if (Employeeslist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }

    public String Employ_update(T_employee employee, boolean isQuit) {
        boolean flag = ed.updateEmployee(employee, isQuit);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String Employ_add(T_employee employee, boolean isQuit, int uid) {
        boolean flag = ed.addEmployee(employee, isQuit, uid);
        EventService eu = new EventService();
        if (!isQuit) {
            eu.EmployeesAddEvent(employee, uid);
        } else {
            eu.EmployeesLeftEvent(employee, uid);
        }
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public void Employ_dele(int eno, boolean isQuit, int uid) {
        T_employee e = getEmployeeById(eno, false);
        Date date = new Date();
        java.sql.Date time = new java.sql.Date(date.getTime());
        e.setEout_date(time);
        EventService eu = new EventService();
        eu.EmployeesLeftEvent(e, uid);
        ed.addEmployee(e, true, uid); 
        ed.deleteEmployee(eno, isQuit);
        PayService ps = new PayService();
        ps.deleteBudget(e);
    }

    public T_employee getEmployeeById(int eno, boolean isQuit) {
        return ed.getEmployeeById(eno, isQuit);
    }

    public JsonElement getListByDno(int dno) {
        List<T_employee> tl = ed.getListByDeptId(dno);
        if (tl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_employee e : tl) {
                JsonObject da = new JsonObject();
                da.add("employee", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
//            String s = "[";
//            s = dl.stream().map((b) -> b.toString() + ",").reduce(s, String::concat);
//            s = s.substring(0, s.length() - 1);
//            s += "]";
            return ja;
        }
    }

    public JsonElement getListJson(boolean isQuit) {
        List<T_employee> tl = ed.selectEmployee(isQuit);
        if (tl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_employee e : tl) {
                JsonObject da = new JsonObject();
                da.add("employee", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }

    public String updateEmployeeDept(int eno, boolean isQuit, int dno, int uid) {
        boolean flag = ed.updateEmployeeDept(eno, isQuit, dno, uid);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    private static final String MSG_SUCCESS;
    private static final String MSG_ERROR;
    private static final JsonObject MSG_ERROR_JSON;
    public static final Gson GSON = new Gson();
    public static final JsonParser JSON_PARSER = new JsonParser();

    static {
        JsonObject su = new JsonObject();
        su.addProperty("msg", "success");
        MSG_SUCCESS = GSON.toJson(su);
        su.addProperty("msg", "error");
        MSG_ERROR = GSON.toJson(su);
        MSG_ERROR_JSON = su;
    }

    public JsonElement getEmployeeJsonElement(int eno, boolean isQuit) {
        T_employee ee = ed.getEmployeeById(eno, isQuit);
        return JSON_PARSER.parse(ee.toString());
    }
}
