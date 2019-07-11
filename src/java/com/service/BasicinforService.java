/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_basicInformationDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pojo.T_basic;
import com.pojo.T_categories;
import java.util.List;

/**
 *
 * @author zhang
 */
public class BasicinforService {

    private T_basicInformationDao bd = new T_basicInformationDao();

    public List<String> getList(String type) {
        return bd.getList(type);
    }

    public String addType(String type, String name) {
        if (name.equals("") || name == null) {
            return "{\"msg\":\"error\"}";
        }
        boolean flag = bd.addType(type, name);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String addCategories(String name, double pa) {
        T_categories c = new T_categories();
        c.setJobTitle(name);
        c.setPostAllowance(pa);
        boolean flag = bd.addCategories(c);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String getCategoriesList() {
        List<T_categories> cl = bd.getCategoriesList();

        if (cl.isEmpty()) {
            return "{\"msg\":\"error\"}";
        } else {
            String s = "[";
            for (T_categories c : cl) {
                s += c.toString() + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "]";
            return s;
        }
    }

    public String getCurrStatistics(String type) {
        List<T_basic> ss = bd.getCurrStatistics(type);

        if (ss.isEmpty()) {
            return "{\"msg\":\"error\"}";
        } else {
            String s = "[";
            for (T_basic b : ss) {
                s += b.toString() + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "]";
            return s;
        }
    }

    public void updateData(String type) {
        bd.updateData(type);
    }

    public void deleteCategories(int id) {
        bd.deleteCategories(id);
    }

    private static final String MSG_SUCCESS;
    private static final String MSG_ERROR;
    private static final JsonObject MSG_ERROR_JSON;
    public static final Gson GSON = new Gson();

    static {
        JsonObject su = new JsonObject();
        su.addProperty("msg", "success");
        MSG_SUCCESS = GSON.toJson(su);
        su.addProperty("msg", "error");
        MSG_ERROR = GSON.toJson(su);
        MSG_ERROR_JSON = su;
    }

    public String updateCategories(int id, String dname, double pa) {
        T_categories c = new T_categories();
        c.setId(id);
        c.setJobTitle(dname);
        c.setPostAllowance(pa);

        boolean flag = bd.updateCategories(c);
        if (flag) {
            return MSG_SUCCESS;
        } else {
            return MSG_ERROR;
        }
    }

    public JsonElement getNameList(String type) {
        List<String> bl = bd.getList(type);

        if (bl.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {

            JsonArray ja = new JsonArray();
            for (String b : bl) {
                JsonObject da = new JsonObject();
                da.addProperty("name", b);
                ja.add(da);
            }
//            String s = "[";
//            for (String b : bl) {
//                s += "{\"name\":\"" + b + "\"}" + ",";
//            }
//            s = s.substring(0, s.length() - 1);
//            s += "]";
//            return s;
            return ja;
        }
    }

    public String getPostAllowance(String type) {
        return "{\"msg\":\"" + bd.getPostAllowance(type) + "\"}";
    }
}
