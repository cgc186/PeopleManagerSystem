/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author zhang
 */
public class T_role {

    private int id;
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    @Override
    public String toString() {
        String s = "{\"id\":\"" + this.id + "\","
                + "\"rolename\":\"" + this.rolename + "\"}";
        return s;
    }
}
