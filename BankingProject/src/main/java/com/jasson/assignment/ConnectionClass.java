package com.jasson.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
public static Connection createConnection() {
	String url = System.getenv("Project_Bank");
	try {
		Connection conn= DriverManager.getConnection(url);
		return conn;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}
}
