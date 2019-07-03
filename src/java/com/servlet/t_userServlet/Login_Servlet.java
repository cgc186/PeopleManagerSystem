/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.t_userServlet;

import com.service.T_userService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 98530
 */
public class Login_Servlet extends HttpServlet {

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
        String username = request.getParameter("uname");
        String password = request.getParameter("upwd");
//        T_user admin = new T_user();
//        T_userDao admindao = new T_userDao();

//        try {
//            admin = admindao.getUserByUname(username);
//        } catch (SQLException e) {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//        if (!admin.isEmpty()) {
//            if (admin.getPassword().equals(password)) {
//                HttpSession session = request.getSession(true);
//                session.setAttribute("username", username);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            }
//        } else {
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }

        
        
        T_userService us = new T_userService();
        String s = us.login(username, password);
        
        PrintWriter out = response.getWriter();

        out.println(s);
        out.flush();
        out.close();
        
//        if (!s.equals("{\"msg\":\"error\"}")) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("username", username);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
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
        processRequest(request, response);
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
