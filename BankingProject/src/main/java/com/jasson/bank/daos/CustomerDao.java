package com.jasson.bank.daos;

import java.util.List;

import com.jasson.assignment.CustomerId;

public interface CustomerDao {
	
	List<CustomerId> getAllCustomer();

	boolean createCustomer(CustomerId c1);
	
	 void updateCustomer(CustomerId CustomerName);
	
	boolean deleteCustomer(CustomerId c1);
	
	List<CustomerId> CustomerId(String Id);

}
