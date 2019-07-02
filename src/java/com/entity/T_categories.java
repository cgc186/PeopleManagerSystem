/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author 98530
 */
//职务类别
public class T_categories {

    private String jobTitle;
    private double postAllowance;
    private int id;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getPostAllowance() {
        return postAllowance;
    }

    public void setPostAllowance(double postAllowance) {
        this.postAllowance = postAllowance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
