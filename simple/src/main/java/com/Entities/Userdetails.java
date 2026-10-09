package com.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Userdetails {
	@Id
	private int id;
	private String name;
	private String password;
	private String roles;
	public Userdetails(int id, String name, String roles,String password) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
		this.password=password;
	}
	public Userdetails() {
		super();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
