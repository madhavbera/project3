package com.ATM.MANAGEMENT.SYSTEM.demo.entity;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDTO {
	private String name;
	private String password;
	private String roles;
	public UserDTO(String name, String password, String roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
	}
	public UserDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
