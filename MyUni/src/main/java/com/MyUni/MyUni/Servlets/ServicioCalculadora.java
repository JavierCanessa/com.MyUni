/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tocho
 */
public class ServicioCalculadora extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/plain;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            try {
//                int nro1 = Integer.parseInt(request.getParameter("nro1"));
//                int nro2 = Integer.parseInt(request.getParameter("nro2"));
//                int resultado = nro1 + nro2;
//                out.println(resultado);
//            } catch (Exception e) {
//                System.out.println("********************************************");
//                System.out.println(e);
//                System.out.println("********************************************");
//            }
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                int nro1 = Integer.parseInt(request.getParameter("nro1"));
                int nro2 = Integer.parseInt(request.getParameter("nro2"));
                int resultado = nro1 + nro2;
                out.println(resultado);
            } catch (Exception e) {
                System.out.println("********************************************");
                System.out.println(e);
                System.out.println("********************************************");
            }
        }

    }

}
