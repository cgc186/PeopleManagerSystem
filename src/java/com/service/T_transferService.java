/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_transferDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_dept;
import com.pojo.T_transfer;
import java.util.List;

/**
 *
 * @author 98530
 */
public class T_transferService {
    private T_transferDao td = new T_transferDao();
    
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
    
    public JsonElement getList() {
        List<T_transfer> dl = td.getList();
        if (dl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {
            JsonArray ja = new JsonArray();
            for (T_transfer d : dl) {
                JsonObject da = new JsonObject();
                da.add("transfer", JSON_PARSER.parse(d.toString()));
                ja.add(da);
            }
            return ja;
        }
    }
}
