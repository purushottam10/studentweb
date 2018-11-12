package com.dz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {


    public Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "system", "admin123");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }//method end
}
