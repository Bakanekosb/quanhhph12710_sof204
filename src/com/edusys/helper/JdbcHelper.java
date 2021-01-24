/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=EDUSYS";
    private static String username = "quang";
    private static String password = "123";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement getStatement(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstm;
        if (sql.trim().startsWith("{")) {
            pstm = conn.prepareCall(sql); // PROC
        } else {
            pstm = conn.prepareStatement(sql); // SQL
        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstm = getStatement(sql, args);
            try {
                pstm.executeUpdate();
            } finally {
                pstm.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstm = getStatement(sql, args);
            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
