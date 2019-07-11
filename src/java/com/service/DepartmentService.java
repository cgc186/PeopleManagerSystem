/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_departmentDao;
import com.dao.T_employeesDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_dept;
import com.pojo.T_employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhang
 */
public class DepartmentService {

    private T_departmentDao d = new T_departmentDao();

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

    public List<T_dept> getList() {
        return d.getList();
    }

    public JsonElement getDeptList() {
        List<T_dept> dl = d.getList();
        if (dl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_dept d : dl) {
                JsonObject da = new JsonObject();
                da.add("dept", JSON_PARSER.parse(d.toString()));
                ja.add(da);
            }
//            String s = "[";
//            s = dl.stream().map((b) -> b.toString() + ",").reduce(s, String::concat);
//            s = s.substring(0, s.length() - 1);
//            s += "]";
            return ja;
        }
    }

    public String addDepartment(T_dept dept) {
        Boolean u1 = d.addDepartment(dept);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String deleteDept(int dno) {
        Boolean u1 = d.deleteDept(dno);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String updateDepartment(T_dept dept) {
        Boolean u1 = d.updateDepartment(dept);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public T_dept getDeptById(int dno) {
        return d.getDeptById(dno);
    }

    public void updateDeptNumber() {
        List<T_dept> dl = getList();
        Map<Integer, Integer> dm = new HashMap<>();
        for (T_dept d : dl) {
            dm.put(d.getDno(), 0);
        }
        T_employeesDao es = new T_employeesDao();
        List<T_employee> el = es.selectEmployee(false);
        for (T_employee e : el) {
            Integer t = dm.get(e.getDno());
            t++;
            dm.replace(e.getDno(), t);
        }
        for (Map.Entry<Integer, Integer> d : dm.entrySet()) {
            updateNumber(d.getKey(), d.getValue());
        }
    }

    private void updateNumber(int dno, int number) {
        d.updateNumber(dno, number);
    }
}
