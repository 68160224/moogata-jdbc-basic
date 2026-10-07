/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Windows
 */
public class UpdateDatabaseFinally {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-basic.db";
        String sql = "UPDATE menu_category SET category_name = ? WHERE category_name = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "สุกี้แห้งพิเศษ");
            stmt.setString(2, "สุกี้แห้ง");
            int affected = stmt.executeUpdate();
            System.out.println("Updated " + affected + " row(s)");
        } catch (SQLException ex) {
            System.err.println("Updated failed: " + ex.getMessage());
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
