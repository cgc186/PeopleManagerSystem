/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author 98530
 */
//职务类别
public class Categories {

    private String JobTitle;
    private double PostAllowance;
    private int id;

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public double getPostAllowance() {
        return PostAllowance;
    }

    public void setPostAllowance(double PostAllowance) {
        this.PostAllowance = PostAllowance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
