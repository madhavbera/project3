package com.employe.info.Zentity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="details")
public class Student {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String name;
	private String Branch;
	public Student( String name, String branch) {
		super();
//		Id = id;
		this.name = name;
		Branch = branch;
	}
	public Student() {
		super();
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	

}