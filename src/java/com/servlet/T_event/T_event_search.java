/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.T_event;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.service.BasicinforService;
import com.service.EventService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 98530
 */
public class T_event_search extends HttpServlet {

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
        int mode = Integer.parseInt(request.getParameter("mode"));
        java.util.Date begintime = null;
        java.util.Date endtime = null;
        EventService es = new EventService();

        JsonElement eventlist = null;
        switch (mode) {
            case 1:
                try {
                    begintime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("begintime"));
                    endtime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endtime"));
                } catch (ParseException ex) {
                    Logger.getLogger(T_event_search.class.getName()).log(Level.SEVERE, null, ex);
                }   eventlist = es.getEventsOverTime(begintime, endtime);
                break;
            case 2:
                {
                    String type = request.getParameter("type");
                    eventlist = es.getEventsByType(type);
                    break;
                }
            case 3:
                {
                    try {
                        begintime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("begintime"));
                        endtime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endtime"));
                    } catch (ParseException ex) {
                        Logger.getLogger(T_event_search.class.getName()).log(Level.SEVERE, null, ex);
                    }       String type = request.getParameter("type");
                    eventlist = es.getEventsTimeType(begintime, endtime, type);
                    break;
                }
            default:
                break;
        }

        PrintWriter out = response.getWriter();

        out.println(eventlist);
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
        EventService es = new EventService();
        JsonObject arr = es.getTimeAndType();
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
