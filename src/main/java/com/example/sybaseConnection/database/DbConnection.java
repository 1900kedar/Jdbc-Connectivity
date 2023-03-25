package com.example.sybaseConnection.database;


import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;
@Component
public class DbConnection {
	
	
	private String url="jdbc:mysql://localhost:3306/tyfoon";
	private String username="root";
	private String password="#Lucknow55@";
	
	
	

	public Connection db() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, username, password);
		
		return con;
		
	}
}
