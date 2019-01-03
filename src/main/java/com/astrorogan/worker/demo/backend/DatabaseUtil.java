/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrorogan.worker.demo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author adamrogan
 */
public class DatabaseUtil {
    
    private static final String databaseUrl = "jdbc:postgresql://localhost:5432/demoDatabase";
    private static final String username = "adamrogan";
    private static final String password = "";
    
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(databaseUrl, username, password);
        return con;
    }
}
