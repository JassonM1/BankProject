package com.jasson.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jasson.assignment.ConnectionClass;
import com.jasson.assignment.CustomerId;
import com.jasson.bank.daos.CustomerDao;
import com.jasson.bank.daos.CustomerPostgressDao;

import io.javalin.http.Handler;

public class CustomerController {
	
	static CustomerDao dao=new CustomerPostgressDao(); 
			
	public static Handler getAllCustomer=ctx->{
//		Connection conn = ConnectionClass.createConnection();
//		String selectCustomers = "select * from customer";
//		
//	    PreparedStatement Pstmt = conn.prepareStatement(selectCustomers); 
//	    ResultSet rs = Pstmt.executeQuery();
//		ArrayList<CustomerId> cList=new ArrayList<CustomerId>();
//		CustomerId c;
//		while(rs.next()) {
//			String id=rs.getString("customer_id");
//			String name=rs.getString("customer_name");
//			c=new CustomerId(id,name);
//			cList.add(c);
		
		List<CustomerId> cList=dao.getAllCustomer();
		ctx.json(cList);
		
		// rs.close();
		// Pstmt.close();
	};

	static CustomerDao dao1=new CustomerPostgressDao();
	
	
	public static Handler createCustomer=ctx->{
//	CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
//	
//	Connection conn = ConnectionClass.createConnection();
//	PreparedStatement Pstmt;
//	
//	
//	Pstmt = conn.prepareStatement("insert into Customer values(?,?)");
//	Pstmt.setString(1, c1.getId());
//	Pstmt.setString(2, c1.getName());
//	Pstmt.execute();
//	ctx.status(201);
//	Pstmt.close();
		
	
	};
	


	public static Handler updateCustomer=ctx->{
	//String id = String.parseString(ctx.pathParam("Id"));
	CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
	Connection conn = ConnectionClass.createConnection();
	PreparedStatement Pstmt;
	
	Pstmt= conn.prepareStatement("update Customer set Customer_id=? where Customer_name=?");
	Pstmt.setString(1, c1.getId());
	Pstmt.setString(2, c1.getName());
	Pstmt.execute();
	ctx.status(200);
	};
	
	public static Handler deleteCustomer=ctx->{
		Connection conn = ConnectionClass.createConnection();
		PreparedStatement Pstmt;
		CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		
		Pstmt = conn.prepareStatement("delete from Customer where Customer_id=?");
		Pstmt.setString(1, c1.getId());
		Pstmt.execute();
		ctx.status(200);
	};
	
	public static Handler CustomerId=ctx->{
		String Id = ctx.pathParam("Id");
		Connection conn= ConnectionClass.createConnection();
		PreparedStatement Pstmt;
		ResultSet rs;
		// CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		
		String allCustomer = "select * from Customer where Customer_id=?";
		Pstmt = conn.prepareStatement(allCustomer);
		Pstmt.setString(1, Id);
		rs = Pstmt.executeQuery();
		
		ArrayList<CustomerId> cList = new ArrayList<CustomerId>();
		CustomerId c;
		
		while(rs.next()) {
			String id=rs.getString("customer_id");
			String name=rs.getString("customer_name");
			c=new CustomerId(id,name);
			cList.add(c);
		}
		rs.close();
		Pstmt.close();
		ctx.json(cList);
		
	};
	

}
