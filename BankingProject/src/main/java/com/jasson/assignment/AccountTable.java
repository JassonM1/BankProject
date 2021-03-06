package com.jasson.assignment;

public class AccountTable {

	private String Account;
	private String Id;
	private int Balance;
	private String Type;
	private String Status;
	
	
	public AccountTable() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public AccountTable(String account, String id, int balance, String type, String status) {
		super();
		Account = account;
		Id = id;
		Balance = balance;
		Type = type;
		Status = status;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "AccountTable [Account=" + Account + ", Id=" + Id + ", Balance=" + Balance + ", Type=" + Type
				+ ", Status=" + Status + "]";
	}
	
	
}
