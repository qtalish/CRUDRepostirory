package com.management.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	 private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String URL = "jdbc:mysql://localhost:3306/test1";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "root";
	 
	    private static Connection connection = null;
	 
	    public static Connection getConnection() {
	        if (connection == null) {
	            try {
	         
	                Class.forName(DRIVER);
	 
	                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	                System.out.println(ex.getMessage());
	            }
	        }
	     
	        return connection;
	    }
}

