package com.Entities;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Dto {
	private String name ;
	private String password;
	private String roles;
	
	public Dto(String name, String password,String roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles=roles;
	}
	public Dto() {
		super();
	}
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
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
	
	

}
