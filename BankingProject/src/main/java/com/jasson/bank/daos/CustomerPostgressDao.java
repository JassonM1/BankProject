package com.jasson.bank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jasson.assignment.ConnectionClass;
import com.jasson.assignment.CustomerId;

public class CustomerPostgressDao implements CustomerDao{

	@Override
	public List<CustomerId> getAllCustomer() {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionClass.createConnection();
		ArrayList<CustomerId> cList=new ArrayList<CustomerId>();
		CustomerId c;
		String selectCustomers = "select * from customer";
	    PreparedStatement Pstmt;
		try {
			Pstmt = conn.prepareStatement(selectCustomers);
			ResultSet rs = Pstmt.executeQuery();
			
			   
			while(rs.next()) {
				String id=rs.getString("customer_id");
				String name=rs.getString("customer_name");
				c=new CustomerId(id,name);
				cList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return cList;
	}
	
	@Override
	public boolean createCustomer(CustomerId c1){
		try (Connection conn = ConnectionClass.createConnection();){
		// CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		// String Customer= "c1";
		
		PreparedStatement Pstmt = conn.prepareStatement("insert into Customer values(?,?)");
		Pstmt.setString(1, c1.getId());
		Pstmt.setString(2, c1.getName());
		Pstmt.execute();
		// ctx.status(201);
		Pstmt.close();
		
		return true;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("could not retrieve Customer", e);
			return false;
	}
	}






	@Override
	public  void updateCustomer(CustomerId c1) {
		
		//CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		try (Connection conn = ConnectionClass.createConnection();){
		PreparedStatement Pstmt;
		
		Pstmt= conn.prepareStatement("update Customer set Customer_id=? where Customer_name=?");
		Pstmt.setString(1, c1.getId());
		Pstmt.setString(2, c1.getName());
		Pstmt.execute();
		// ctx.status(200);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
			
	
	


	@Override
	public boolean deleteCustomer(CustomerId c1) {
		try (Connection conn = ConnectionClass.createConnection();){
		PreparedStatement Pstmt;
		// CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		
		Pstmt = conn.prepareStatement("delete from Customer where Customer_id=?");
		Pstmt.setString(1, c1.getId());
		Pstmt.execute();
		// ctx.status(200);
		return true;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("could not retrieve Customer", e);
			return false;
	}};
	
	
	
	public List<CustomerId> CustomerId(String Id){
		ArrayList<CustomerId> cList = new ArrayList<CustomerId>();
	   try (Connection conn= ConnectionClass.createConnection();){
		// String Id = ctx.pathParam("Id");
		
		PreparedStatement Pstmt;
		ResultSet rs;
		// CustomerId c1 = ctx.bodyAsClass(CustomerId.class);
		
		String allCustomer = "select * from Customer where Customer_id=?";
		Pstmt = conn.prepareStatement(allCustomer);
		Pstmt.setString(1, Id);
		rs = Pstmt.executeQuery();
		
		
		CustomerId c;
		
		while(rs.next()) {
			String id=rs.getString("customer_id");
			String name=rs.getString("customer_name");
			c=new CustomerId(id,name);
			cList.add(c);
		
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}  
			
			return cList;
		}
	   
	
	
	
}
		
	   


