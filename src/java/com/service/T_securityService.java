/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_securityDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_labor;
import com.pojo.T_security;
import static com.service.T_laborService.JSON_PARSER;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_securityService {

    T_securityDao sd = new T_securityDao();
    private static final JsonObject MSG_ERROR_JSON;
    public static final Gson GSON = new Gson();
    public static final JsonParser JSON_PARSER = new JsonParser();

    static {
        JsonObject su = new JsonObject();
        su.addProperty("msg", "error");
        MSG_ERROR_JSON = su;
    }

    public JsonElement getList() {
        List<T_security> sl = sd.getList();
        if (sl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_security e : sl) {
                JsonObject da = new JsonObject();
                da.add("security", JSON_PARSER.parse(e.toString()));
                ja.add(da);
            }
            return ja;
        }
    }

    public String add(T_security s) {
        boolean flag = sd.add(s);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }
}
