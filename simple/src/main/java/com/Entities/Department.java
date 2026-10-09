package com.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class Department {
	@Id
	private int id;
	private String depat_name;
	public Department(int id, String depat_name) {
		super();
		this.id = id;
		this.depat_name = depat_name;
	}
	public Department() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepat_name() {
		return depat_name;
	}
	public void setDepat_name(String depat_name) {
		this.depat_name = depat_name;
	}
	

}
