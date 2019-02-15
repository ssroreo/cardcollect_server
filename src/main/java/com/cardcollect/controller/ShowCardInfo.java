package com.cardcollect.controller;

import com.cardcollect.controller.DB.ConnDB;
import com.cardcollect.controller.domain.CardBag;
import com.cardcollect.controller.domain.CardInfo;

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

@WebServlet(name = "ShowCardInfo",urlPatterns = "/ShowCardInfo")
public class ShowCardInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bagid = request.getParameter("bagid");
        Connection conn = ConnDB.getConnection();
        ConnDB.closeConnection(conn);
        String sql = "select * from cardinfo where bagid="+bagid+" order by cardnum;";
        System.out.println(sql);
        List<CardInfo> bagList = showCardInfo(sql);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("{\"cardinfo\":[");
        String strCardInfo = "";
        for (int i=0;i<bagList.size();i++){
            strCardInfo+=("{\"cardname\":\""+(bagList.get(i).getCardname())+"\"}");
            if(i!=bagList.size()-1) strCardInfo+=",";
        }
        out.println(strCardInfo+"]}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public List<CardInfo> showCardInfo(String sql) {
        // TODO Auto-generated method stub
        Connection conn = ConnDB.getConnection();
        PreparedStatement stmt = ConnDB.getPreparedStatement(conn,sql);
        ResultSet rs = ConnDB.getResultSet(stmt);
        List<CardInfo> cardInfoList = new ArrayList();
        try {
            while(rs.next())
            {
                CardInfo cardInfo = new CardInfo();
                cardInfo.setCardname(rs.getString("cardname"));
                cardInfoList.add(cardInfo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("UserDaoImpl中取得数据失败");
            e.printStackTrace();
        }
        ConnDB.closePreparedStatement(stmt);
        ConnDB.closeResultSet(rs);
        ConnDB.closeConnection(conn);
        return cardInfoList;
    }
}
