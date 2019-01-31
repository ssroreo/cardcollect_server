package com.cardcollect.controller.DB;


import java.sql.*;

/**
 * 处理数据库连接的类
 *
 */
public class ConnDB {

    // 常量的设置
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://pokerin.top:3306/cardcollect?serverTimezone=UTC&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    // 取得数据库连接；
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            System.out.println("数据库加载驱动成功!");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库加载驱动失败!");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("数据库连接成功!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库连接失败!");
            e.printStackTrace();
        }
        return conn;

    }
    //获取Statement对象
    public static Statement getStatement(Connection conn)
    {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            System.out.println("获取Statement对象成功!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("获取Statement对象失败!");
            e.printStackTrace();
        }
        return stmt;

    }
    //获取ResultSet对象
    public static ResultSet getResultSet(PreparedStatement stmt)
    {
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();
            System.out.println("获取ResultSet对象成功!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("获取ResultSet对象失败!");
            e.printStackTrace();
        }
        return rs;
    }
    //关闭ResultSet
    public static void closeResultSet(ResultSet rs)
    {
        if(rs != null)
        {
            try {
                rs.close();
                System.out.println("关闭ResultSet对象成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭ResultSet对象失败!");
                e.printStackTrace();
            }
            rs = null;
        }
    }
    //关闭Statement
    public static void closeStatement(Statement stmt)
    {
        if(stmt != null)
        {
            try {
                stmt.close();
                System.out.println("关闭Statement对象成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭Statement对象失败!");
                e.printStackTrace();
            }
            stmt = null;
        }
    }
    //关闭Connection
    public static void closeConnection(Connection conn)
    {
        if(conn != null)
        {
            try {
                conn.close();
                System.out.println("关闭Connection对象成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭Connection对象失败!");
                e.printStackTrace();
            }
            conn = null;
        }
    }
    //获取Statement对象
    public static PreparedStatement getPreparedStatement(Connection conn,String sql)
    {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            System.out.println("获取Statement对象成功!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("获取Statement对象失败!");
            e.printStackTrace();
        }
        return stmt;
    }
    //关闭Statement
    public static void closePreparedStatement(PreparedStatement stmt)
    {
        if(stmt != null)
        {
            try {
                stmt.close();
                System.out.println("关闭Statement对象成功!");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("关闭Statement对象失败!");
                e.printStackTrace();
            }
            stmt = null;
        }
    }
    public static ResultSet getResultSet(Statement stmt,String sql)
    {
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery(sql);
            System.out.println("获取ResultSet对象成功!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("获取ResultSet对象失败!");
            e.printStackTrace();
        }
        return rs;
    }
}

