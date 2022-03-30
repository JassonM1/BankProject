package com.jasson.bank.daos;

import java.util.List;

import com.jasson.assignment.AccountTable;

public interface AccountDao {
	
	 List<AccountTable> getAllAccounts(String Id);
	 
	 boolean createAccount(AccountTable a1);
	 
}
