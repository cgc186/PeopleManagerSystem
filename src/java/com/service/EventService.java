/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_eventDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_employee;
import com.pojo.T_event;
import com.pojo.T_transfer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 98530
 */
public class EventService {

    private T_eventDao ed = new T_eventDao();

    private void AddEvent(String content, String type, int uid) {
        T_event e = new T_event();

        java.sql.Date time = new java.sql.Date(new Date().getTime());
        e.setTime(time);
        e.setContent(content);
        e.setType(type);
        e.setOperator(uid);
        ed.addEvent(e);
    }

    public void EmployeesAddEvent(T_employee ee, int uid) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname()
                + "入职,进入的部门编号为" + ee.getDno();
        AddEvent(content, "员工入职", uid);
    }

    public void EmployeesLeftEvent(T_employee ee, int uid) {
        String content = null;
        content = "编号为" + ee.getEno() + "的员工" + ee.getEname() + "离职";
        AddEvent(content, "员工离职", uid);
    }

    public void EmployeesTransferEvent(T_transfer t, int uid) {
        String content = null;
        content = "编号为" + t.getEno() + "的员工从"
                + t.getPrevdept() + "调到了" + t.getCurrdept() + "部门";
        AddEvent(content, "员工借调", uid);
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

    public JsonElement getEventList() {
        List<T_event> el = ed.getEventList();
        if (el.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_event e : el) {
                JsonObject da = new JsonObject();
                da.add("event", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }

    public JsonElement getEventsOverTime(Date d1, Date d2) {
        List<T_event> el = ed.getEventsOverTime(d1, d2);
        if (el.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_event e : el) {
                JsonObject da = new JsonObject();
                da.add("event", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }
    
    public JsonElement getEventsByType(String type){
        List<T_event> el = ed.getEventsByType(type);
        if (el.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_event e : el) {
                JsonObject da = new JsonObject();
                da.add("event", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }
    
    public JsonElement getEventsTimeType(Date d1, Date d2,String type){
        List<T_event> el = ed.getEventsTimeType(d1, d2, type);
        if (el.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_event e : el) {
                JsonObject da = new JsonObject();
                da.add("event", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }

    public JsonObject getTimeAndType() {
        List<Date> timelist = ed.getTime();
        List<String> typelist = ed.getType();

        JsonArray timea = new JsonArray();
        for (Date d : timelist) {
            JsonObject da = new JsonObject();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String data = formatter.format(d);
            da.addProperty("time",data);
            timea.add(da);
        }

        JsonArray typea = new JsonArray();
        for (String t : typelist) {
            JsonObject da = new JsonObject();
            da.addProperty("type", t);
            typea.add(da);
        }

        JsonObject arr = new JsonObject();
        arr.add("time", timea);
        arr.add("type", typea);
        return arr;
    }
}
