package com.cardcollect.controller;

import com.cardcollect.controller.DB.ConnDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "ShowCard",urlPatterns = "/ShowCard")
public class ShowCard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = ConnDB.getConnection();
        ConnDB.closeConnection(conn);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("ƒ„∫√ ¿ΩÁ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
