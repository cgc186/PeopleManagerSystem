/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.T_menuDao;
import com.dao.T_roleDao;
import com.dao.T_userDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pojo.T_menu;
import com.pojo.T_role;
import com.pojo.T_user;
import static com.service.DepartmentService.JSON_PARSER;
import java.util.List;

/**
 *
 * @author zhang
 */
public class T_roleService {

    private T_roleDao rd = new T_roleDao();
    private T_menuDao td = new T_menuDao();
    private T_userDao tu = new T_userDao();
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

    public String Role_list() {
        List<T_role> rolelist = rd.getRoleList();
        String list = "[";
        for (int i = 0; i < rolelist.size(); i++) {
            list += rolelist.get(i).toString() + ",";
        }
        if (rolelist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }

    public JsonElement getByRid(int rid) {
        List<T_menu> menulist = td.getByRid(rid);
        if (menulist.isEmpty()) {
            return MSG_ERROR_JSON;
        } else {

            JsonArray ja = new JsonArray();
            for (T_menu m : menulist) {
                JsonObject da = new JsonObject();
                da.add("menu", JSON_PARSER.parse(m.toString()));
                ja.add(da);
            }
            return ja;
        }
    }

    public String addrole(T_role role) {
        Boolean u1 = rd.addRole(role);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String deleteRole(int rid) {
        boolean flag = rd.deleterole(rid);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String insertRolemenu(int rid, int mid) {
        Boolean u1 = rd.insertRolemenu(rid,mid);
        if (!u1) {
            return "{\"msg\":\"error\"}";
        } else {
            return "{\"msg\":\"success\"}";
        }
    }

    public String deleteRolemenu(int rid, int mid) {
        boolean flag = rd.deleterolemenu(rid, mid);
        if (flag) {
            return "{\"msg\":\"success\"}";
        } else {
            return "{\"msg\":\"error\"}";
        }
    }

    public String getUserlist(int rid) {
        List<T_user> userlist = tu.getUserListbyRid(rid);
        String list = "[";
        for (int i = 0; i < userlist.size(); i++) {
            list += userlist.get(i).toString() + ",";
        }
        if (userlist.size() > 0) {
            list = list.substring(0, list.length() - 1);
        }
        list += "]";
        return list;
    }

    public JsonElement getMenu() {
        List<T_menu> menulist = td.getMenu();
        if (menulist.isEmpty()) {
            return null;
        } else {

            JsonArray ja = new JsonArray();
            for (T_menu m : menulist) {
                JsonObject da = new JsonObject();
                da.add("menu", JSON_PARSER.parse(m.toString()));
                ja.add(da);
            }

            return ja;
        }
    }
}
