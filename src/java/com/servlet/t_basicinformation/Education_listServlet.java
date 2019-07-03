/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.t_basicinformation;

import com.dao.T_basicInformationDao;
import com.pojo.T_basic;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zhang
 */
@WebServlet(name = "Education_Servlet", urlPatterns = {"/Education_Servlet"})
public class Education_listServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");
        T_basicInformationDao basicdao = new T_basicInformationDao();
        List<T_basic> Basiclist = basicdao.getCurrStatistics(type);
        request.setAttribute("Basiclist", Basiclist);
        if(type.equals("culture")){
            request.getRequestDispatcher("degree.jsp").forward(request, response);
        }
        request.getRequestDispatcher("degree.jsp").forward(request, response);
        /*
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");
         T_basicInformationDao basicdao = new T_basicInformationDao();
        Map<String, Integer> es = basicdao.getStatistics(String type);
        request.setAttribute("es", es);
        request.getRequestDispatcher("Basiclist.jsp").forward(request, response);
        
        
        
        
        
        
        
        
        
        
        
        
        
        */
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
