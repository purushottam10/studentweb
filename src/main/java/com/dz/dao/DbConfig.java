package com.dz.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {


    private static Logger log = Logger.getLogger(StudentDao.class.getName());

    public Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
          log.error(e.getMessage(),e);
        }

        try {
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", "system", "admin123");

        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }//method end
}
