package com.example.moogata.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class CreateTableFinally {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-create.db";
        String sql = "CREATE TABLE menu_category ("
                + "category_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "category_name TEXT NOT NULL UNIQUE)";
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Table ready: menu_category");
        } catch (SQLException ex) {
            System.err.println("Create failed: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException closeEx) {
                    System.err.println("Close stmt failed: " + closeEx.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Close conn failed: " + closeEx.getMessage());
                }
            }
        }
    }
}
