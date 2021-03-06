package com.jasson.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jasson.assignment.AccountTable;
import com.jasson.assignment.ConnectionClass;
import com.jasson.assignment.CustomerId;

import io.javalin.http.Handler;

public class AccountController {

	public static Handler getAllAccounts=ctx->{
		String Id = ctx.pathParam("Id");
		
		Connection conn = ConnectionClass.createConnection();
		PreparedStatement Pstmt;
		ResultSet rs;
		String selectAccount = "select * from account where Customer_id=?";
		
	    Pstmt = conn.prepareStatement(selectAccount);
	    Pstmt.setString(1, Id);
	    rs = Pstmt.executeQuery();
	    
	   
		ArrayList<AccountTable> aList=new ArrayList<AccountTable>();
		AccountTable a;
		while(rs.next()) {
			String Account=rs.getString("account_number");
			String id=rs.getString("customer_id");
			int Balance=rs.getInt("account_balance");
			String Type=rs.getString("account_type");
			String Status=rs.getString("account_status");
			
			
			a=new AccountTable(Account, id, Balance, Type, Status);
			aList.add(a);
		}
		ctx.json(aList);
		rs.close();
		Pstmt.close();
	
};
public static Handler createAccount=ctx->{
	AccountTable a1 = ctx.bodyAsClass(AccountTable.class);
	
	Connection conn = ConnectionClass.createConnection();
	PreparedStatement Pstmt;
	ResultSet rs;
	
	
	Pstmt = conn.prepareStatement("insert into Account(account_number, customer_id, account_balance, account_type, account_status) values(?,?,?,?,?)");
	Pstmt.setString(1, a1.getAccount());
	Pstmt.setString(2, a1.getId());
	Pstmt.setInt(3, a1.getBalance());
	Pstmt.setString(4, a1.getType());
	Pstmt.setString(5, a1.getStatus());
	
	Pstmt.execute();
	ctx.status(201);
	Pstmt.close();
	};

}
