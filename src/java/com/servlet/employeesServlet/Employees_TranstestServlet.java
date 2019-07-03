/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.employeesServlet;

import com.dao.DepartmentDao;
import com.dao.EmployeesDao;
import com.pojo.T_dept;
import com.pojo.T_employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zhang
 */
@WebServlet(name = "Employees_TranstestServlet", urlPatterns = {"/Employees_TranstestServlet"})
public class Employees_TranstestServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int no = Integer.parseInt(request.getParameter("eno"));
        String date = request.getParameter("dno");
        String delimeter = " ";  // 指定分割字符
        String[] temp = date.split(delimeter);
        int dno = Integer.parseInt(temp[1]);
        EmployeesDao e = new EmployeesDao();
        e.updateEmployeeDept(no, false, dno);
        request.getRequestDispatcher("Employees_listServlet?isQuit=false").forward(request, response);
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
        //先弄部门编号，后续可加部门名称等内容
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //boolean isQuit = Boolean.parseBoolean(request.getParameter("isQuit"));
        int no = Integer.parseInt(request.getParameter("eno"));
        EmployeesDao e = new EmployeesDao();
        List employeeslist = e.selectEmployee(false);
        request.setAttribute("employeeslist", employeeslist);
        request.getRequestDispatcher("employees_transfer.jsp").forward(request, response);
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
