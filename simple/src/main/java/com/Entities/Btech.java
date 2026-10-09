package com.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Btech")
public class Btech {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToOne
	@JoinColumn(name="Bca_id")
	private Bca bca;
	public Btech( String name) {
		super();
//		this.id = id;
		this.name = name;
//		this.bca = bca;
	}
	public Btech() {
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
	public Bca getBca() {
		return bca;
	}
	public void setBca(Bca bca) {
		this.bca = bca;
	}
	
	

}
