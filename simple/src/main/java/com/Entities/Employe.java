package com.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Employe {
	@Id
	private int id;
	private String name;
	@OneToOne
	@JoinColumn(name="departmeant_id")
	private Department dept;
	public Employe(int id, String name,Department dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept=dept;
	}
	public Employe() {
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	

}
