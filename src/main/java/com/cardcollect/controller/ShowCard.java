package com.cardcollect.controller;

import com.cardcollect.controller.DB.ConnDB;
import com.cardcollect.controller.domain.CardBag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowCard",urlPatterns = "/ShowCard")
public class ShowCard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = ConnDB.getConnection();
        ConnDB.closeConnection(conn);
        String sql = "select * from baginfo";
        List<CardBag> bagList = showCardBag(sql);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("{\"baginfo\":[");
        String strBagInfo = "";
        for (int i=0;i<bagList.size();i++){
            strBagInfo+=("{\"id\":\""+bagList.get(i).getId()+"\",\"title\":\""+(bagList.get(i).getBagName())+"\",\"img\":\""+(bagList.get(i).getImg())+"\"," +
                    "\"url\":\"../index/index\"}");
            if(i!=bagList.size()-1) strBagInfo+=",";
        }
        out.println(strBagInfo+"]}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public List<CardBag> showCardBag(String sql) {
        // TODO Auto-generated method stub
        Connection conn = ConnDB.getConnection();
        PreparedStatement stmt = ConnDB.getPreparedStatement(conn,sql);
        ResultSet rs = ConnDB.getResultSet(stmt);
        List<CardBag> cardBagList = new ArrayList();
        try {
            while(rs.next())
            {
                CardBag cardBag = new CardBag();
                cardBag.setId(rs.getInt("id"));
                cardBag.setBagName(rs.getString("bagname"));
                cardBag.setImg(rs.getString("img"));
                cardBagList.add(cardBag);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("UserDaoImpl中取得数据失败");
            e.printStackTrace();
        }
        ConnDB.closePreparedStatement(stmt);
        ConnDB.closeResultSet(rs);
        ConnDB.closeConnection(conn);
        return cardBagList;
    }
}
