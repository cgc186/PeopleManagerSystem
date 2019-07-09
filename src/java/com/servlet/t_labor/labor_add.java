/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.t_labor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pojo.T_labor;
import com.service.BasicinforService;
import com.service.DepartmentService;
import com.service.EmployService;
import com.service.T_laborService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 98530
 */
public class labor_add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int eno = Integer.parseInt(request.getParameter("eno"));
        String category = request.getParameter("category");
        int dno = Integer.parseInt(request.getParameter("dno"));
        java.sql.Date startTime = null;
        java.sql.Date endTime = null;
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startTime"));
            startTime = new java.sql.Date(date.getTime());
            java.util.Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endTime"));
            endTime = new java.sql.Date(enddate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double msal = Double.parseDouble(request.getParameter("msal"));

        T_labor l = new T_labor();
        l.setEno(eno);
        l.setCategory(category);
        l.setDno(dno);
        l.setStartTime(startTime);
        l.setMsal(msal);
        l.setEndTime(endTime);

        T_laborService ld = new T_laborService();
        String s = ld.addLabor(l);
        PrintWriter out = response.getWriter();

        out.println(s);
        out.flush();
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        BasicinforService bs = new BasicinforService();
        JsonElement categorieslist = bs.getNameList("categories");

        EmployService es = new EmployService();
        JsonElement employeeslist = es.getListJson(false);

        DepartmentService d = new DepartmentService();
        JsonElement deptlist = d.getDeptList();

        JsonObject arr = new JsonObject();

        arr.add("categorieslist", categorieslist);
        arr.add("deptlist", deptlist);
        arr.add("employeeslist", employeeslist);

        String json = BasicinforService.GSON.toJson(arr);

        PrintWriter out = response.getWriter();

        out.println(json);
        out.flush();
        out.close();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
