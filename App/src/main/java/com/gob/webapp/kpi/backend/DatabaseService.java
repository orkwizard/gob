package com.gob.webapp.kpi.backend;

import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

	private static DatabaseService databaseService;
	private Connection connPool;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/Gobierno?useSSL=false";
	static final String USER = "app";
	static final String PASS = "Sys73xrv21";
	  
	private DatabaseService() throws IOException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
	}
	  
	public static DatabaseService getInstance() throws IOException{
		if (databaseService == null) {
		      databaseService = new DatabaseService();
		    }
		    return databaseService;
	}
	
	public Connection getConnection() throws SQLException {
		connPool = DriverManager.getConnection(DB_URL,USER,PASS);
	    return connPool;
	  }

}
