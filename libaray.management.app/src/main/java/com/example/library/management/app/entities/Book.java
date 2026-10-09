package com.example.library.management.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="book")//Name of the table
public class Book {
	@jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)//This line automatically generate the value of id

     private int Id;
	 private String BookName;
	 private String author;
 
 public Book( String BookName, String author) {
		super();

	this.BookName = BookName;
		this.author = author;
	}

 public Book() {
	super();
}


 
 public String getBookName() {
	return BookName;
 }
 public String getAuthor() {
	return author;
}

 public void setAuthor(String author) {
	this.author = author;
 }

 public void setBookName(String bookName) {
	 BookName= bookName;
 }
 public int getId() {
	return Id;
 }
 public void setId(int id) {
	Id = id;
 }
 
}
