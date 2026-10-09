package com.ATM.MANAGEMENT.SYSTEM.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ATM {
	@Id
	private int id;
	private String customer_name;
	private long pin_code;
	private String gender;
	public ATM(int id, String customer_name, long pin_code, String gender) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.pin_code = pin_code;
		this.gender = gender;
	}
	public ATM() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getPin_code() {
		return pin_code;
	}
	public void setPin_code(long pin_code) {
		this.pin_code = pin_code;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
