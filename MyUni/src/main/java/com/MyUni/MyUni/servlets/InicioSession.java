/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyUni.MyUni.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javiercanessa
 */
public class InicioSession extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            HttpSession session = request.getSession();
//
//            String user = request.getParameter("user");
//            String pass = request.getParameter("pass");
//            if (user != null && pass != null
//                    && user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("pcardenas")) {
//                session.setAttribute("session", true);
//                session.setAttribute("user", user);
//                response.sendRedirect("ingresoadmin.jsp");
//            } else {
//                session.setAttribute("session", false);
//                out.println("<script type=\"text/javascript\">");
//                out.println("alert('Contraseña incorrecta');");
//                out.println("location='index.jsp';");
//                out.println("</script>");
//            }
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if (user != null && pass != null
                    && user.equalsIgnoreCase("unistudent") && pass.equalsIgnoreCase("danielgael")) {
                session.setAttribute("session", true);
                session.setAttribute("user", user);
                response.sendRedirect("ingresoadmin.jsp");
            } else {
                session.setAttribute("session", false);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Contraseña incorrecta');");
                out.println("location='indexInicio.jsp';");
                out.println("</script>");
            }
        }    }

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
