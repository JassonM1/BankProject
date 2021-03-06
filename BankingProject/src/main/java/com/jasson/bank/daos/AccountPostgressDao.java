package com.jasson.bank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jasson.assignment.AccountTable;
import com.jasson.assignment.ConnectionClass;

public class AccountPostgressDao implements AccountDao  {

	@Override
	public ArrayList<AccountTable> getAllAccounts(String Id) {
	// String Id = ctx.pathParam("Id");
	PreparedStatement Pstmt;
	ResultSet rs;
	String selectAccount = "select * from account where Customer_id=?";
	
   
    
   
	ArrayList<AccountTable> aList=new ArrayList<AccountTable>();
	AccountTable a;
	
	try (Connection conn = ConnectionClass.createConnection();){
		 Pstmt = conn.prepareStatement(selectAccount);
    Pstmt.setString(1, Id);
    rs = Pstmt.executeQuery();
    
    while(rs.next()) {
		String Account=rs.getString("account_number");
		String id=rs.getString("customer_id");
		int Balance=rs.getInt("account_balance");
		String Type=rs.getString("account_type");
		String Status=rs.getString("account_status");
		
		
		a=new AccountTable(Account, id, Balance, Type, Status);
		aList.add(a);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	return aList;
	}

	@Override
	public boolean createAccount(AccountTable a1) {
		// TODO Auto-generated method stub
		// AccountTable a1 = ctx.bodyAsClass(AccountTable.class);
		String sql = "insert into Account(account_number, customer_id, account_balance, account_type, account_status) values(?,?,?,?,?)";
		try (Connection conn = ConnectionClass.createConnection();){
		PreparedStatement Pstmt;
		ResultSet rs;
		
		
		Pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		//Pstmt = conn.prepareStatement("insert into Account(account_number, customer_id, account_balance, account_type, account_status) values(?,?,?,?,?)");
		Pstmt.setString(1, a1.getAccount());
		Pstmt.setString(2, a1.getId());
		Pstmt.setInt(3, a1.getBalance());
		Pstmt.setString(4, a1.getType());
		Pstmt.setString(5, a1.getStatus());
		
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
	
	
}

