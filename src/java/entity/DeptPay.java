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
public class DeptPay {

    private int dno;
    private double bugget;
    private double ActualBudget;

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public double getBugget() {
        return bugget;
    }

    public void setBugget(double bugget) {
        this.bugget = bugget;
    }

    public double getActualBudget() {
        return ActualBudget;
    }

    public void setActualBudget(double ActualBudget) {
        this.ActualBudget = ActualBudget;
    }

}
