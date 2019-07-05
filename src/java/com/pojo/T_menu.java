/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author 98530
 */
public class T_menu {
    private int id;
    private String menutext;
    private String url;
    private int father;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenutext() {
        return menutext;
    }

    public void setMenutext(String menutext) {
        this.menutext = menutext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    @Override
    public String toString() {
        String s = "{\"id\":\"" + this.id + "\","
                + "\"menutext\":\"" + this.menutext + "\","
                + "\"url\":\"" + this.url + "\","
                + "\"father\":\"" + this.father + "\"}";
        return s;
    }
    
    
}
