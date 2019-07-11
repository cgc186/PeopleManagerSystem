/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.T_security;

import com.pojo.T_security;
import com.service.EmployService;
import com.service.T_securityService;
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
public class security_add extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int eno = Integer.parseInt(request.getParameter("eno"));
        String number = request.getParameter("number");
        String state = request.getParameter("state");
        java.sql.Date startTime = null;
        java.sql.Date endTime = null;
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("starttime"));
            startTime = new java.sql.Date(date.getTime());
            java.util.Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endtime"));
            endTime = new java.sql.Date(enddate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double month = Double.parseDouble(request.getParameter("month"));
        double esal = Double.parseDouble(request.getParameter("esal"));

        T_security s = new T_security();
        
        s.setId(id);
        s.setName(name);
        s.setEno(eno);
        s.setNumber(number);
        s.setState(state);
        s.setStarttime(startTime);
        s.setEndtime(endTime);
        s.setMonth(month);
        s.setEsal(esal);

        T_securityService ss = new T_securityService();
        String msg = ss.add(s);
        PrintWriter out = response.getWriter();

        out.println(msg);
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
        boolean isQuit = Boolean.parseBoolean(request.getParameter("isQuit"));
        EmployService es = new EmployService();
        String Employeeslist = es.Employ_list(isQuit);
        PrintWriter out = response.getWriter();
        out.println(Employeeslist);
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
