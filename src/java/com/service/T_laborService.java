/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_laborDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_labor;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_laborService {

    private T_laborDao ld = new T_laborDao();
    private static final JsonObject MSG_ERROR_JSON;
    public static final Gson GSON = new Gson();
    public static final JsonParser JSON_PARSER = new JsonParser();

    static {
        JsonObject su = new JsonObject();
        su.addProperty("msg", "error");
        MSG_ERROR_JSON = su;
    }

    public JsonElement getLaborList() {
        List<T_labor> ll = ld.getLaborList();
        if (ll.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_labor e : ll) {
                JsonObject da = new JsonObject();
                da.add("labor", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }
    
    public String update(int id,int time){
        int flag = ld.update(id,time);
        if (flag > 0) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String Relieve(int id) {
        int flag = ld.Relieve(id);
        if (flag > 0) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }
}
