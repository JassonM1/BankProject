package com.jasson.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankProject {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String url= System.getenv("Project_Bank");
		 conn=DriverManager.getConnection(url);
		 
		 stmt = conn.createStatement();
		 
		 String selectCustomer="select * from customer";
		rs= stmt.executeQuery(selectCustomer);
		 
		
		 while(rs.next()) {
			 System.out.println(rs.getString(1)+" "+rs.getString("customer_name"));
		 }
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	


