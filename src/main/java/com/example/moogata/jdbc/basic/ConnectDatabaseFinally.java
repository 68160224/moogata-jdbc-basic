package com.example.moogata.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Path;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class ConnectDatabaseFinally {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:moogata-basic.db";
        System.out.println("Database: " + Path.of("moogata-basic.db").toAbsolutePath());
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected: " + !conn.isClosed());
        } catch (SQLException ex) {
            System.err.println("Connect failed: " + ex.getMessage());
        } finally {
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
