package com.example.moogata.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Windows
 */
public class SelectDatabaseFinally {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-basic.db";
        String sql = "SELECT category_id, category_name FROM menu_category ORDER BY category_id";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("category_id") + " | "
                        + rs.getString("category_name"));
            }
        } catch (SQLException ex) {
            System.err.println("Select failed: " + ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException closeEx) {
                    System.err.println("Close rs failed: " + closeEx.getMessage());
                }
            }
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
