/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.employeesServlet;

import com.dao.BasicInformationDao;
import com.dao.DepartmentDao;
import com.dao.EmployeesDao;
import com.entity.Department;
import com.entity.Employee;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 98530
 */
public class Employees_addServlet extends HttpServlet {

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
        boolean isQuit = Boolean.parseBoolean(request.getParameter("isQuit"));
        Employee employee = new Employee();
        int eno = Integer.parseInt(request.getParameter("eno"));
        String ename = request.getParameter("ename");
        double esal = Double.parseDouble(request.getParameter("esal"));
        String esex = request.getParameter("esex");
        int eage = Integer.parseInt(request.getParameter("eage"));
        int etel = Integer.parseInt(request.getParameter("etel"));
        String enational = request.getParameter("enational");;
        String etype = request.getParameter("etype");
        java.sql.Date ein_date = null;
        java.sql.Date eout_date = null;
        try {
            if (!isQuit) {
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ein_date"));
                //System.out.print(date.getTime());
                ein_date = new java.sql.Date(date.getTime());
                employee.setEin_date(ein_date);
            } else {
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("eout_date"));
                //System.out.print(date.getTime());
                eout_date = new java.sql.Date(date.getTime());
                employee.setEin_date(eout_date);
            }
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        String eculture = request.getParameter("eculture");
        
        String date = request.getParameter("dno");
        String delimeter = " ";  // 指定分割字符
        String[] temp = date.split(delimeter);
        int dno = Integer.parseInt(temp[1]);

        employee.setEno(eno);
        employee.setEname(ename);
        employee.setEsal(esal);
        employee.setEsex(esex);
        employee.setEage(eage);
        employee.setEtel(etel);
        employee.setEnational(enational);
        employee.setEtype(etype);

        employee.setEculture(eculture);
        employee.setDno(dno);
        EmployeesDao EmployeesDao = new EmployeesDao();
        EmployeesDao.addEmployee(employee, isQuit);
        if (!isQuit) {
            request.getRequestDispatcher("Employees_listServlet?isQuit=false").forward(request, response);
        } else {
            request.getRequestDispatcher("Employees_listServlet?isQuit=true").forward(request, response);
        }
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
        String nation="national";
        String edu="culture";
        BasicInformationDao b = new BasicInformationDao();
        List<String> nationlist=b.getList(nation);
        List<String> culturelist=b.getList(edu);
        List<String> categorieslist = b.getList("categories");
        DepartmentDao departmentdao = new DepartmentDao();
        List<Department> deptlist = departmentdao.selectDepartment();
        request.setAttribute("nationlist", nationlist);
        request.setAttribute("culturelist", culturelist);
        request.setAttribute("categorieslist", categorieslist);
        request.setAttribute("deptlist", deptlist);
        request.setCharacterEncoding("utf-8");
        if (!isQuit) {
            request.getRequestDispatcher("employees_insert.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Employees_listServlet?isQuit=true").forward(request, response);
        }
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