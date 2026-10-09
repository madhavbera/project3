package com.example.library.management.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	private int id;
	private String name;
	private  String email_id;
	private double balance;
	private long account_no;
	public Account(int id, String name, String email_id, double balance,long account_no) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.balance = balance;
		this.account_no=account_no;
	}
	
//	public Account(double balance) {
//		super();
//		this.balance = balance;
//	}

	public Account() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}
	
	

}
