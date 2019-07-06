/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.t_employeesServlet;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.service.BasicinforService;
import com.service.DepartmentService;
import com.service.EmployService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 98530
 */
public class Employee_transfer extends HttpServlet {

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
        int no = Integer.parseInt(request.getParameter("eno"));
        int dno = Integer.parseInt(request.getParameter("dno"));

        EmployService e = new EmployService();
        String s = e.updateEmployeeDept(no, false, dno);
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
        //boolean isQuit = Boolean.parseBoolean(request.getParameter("isQuit"));
        int no = Integer.parseInt(request.getParameter("eno"));

        DepartmentService d = new DepartmentService();
        JsonElement deptlist = d.getDeptList();

        EmployService e = new EmployService();
        JsonElement ee = e.getEmployeeJsonElement(no, false);

        JsonObject arr = new JsonObject();
        arr.add("deptlist", deptlist);
        arr.add("employ", ee);
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
