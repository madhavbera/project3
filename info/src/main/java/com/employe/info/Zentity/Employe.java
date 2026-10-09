package com.employe.info.Zentity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Employe {
   @Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
   private int Id;
   private String name;
   private int salary;
   private String post;
   
   public Employe() {
	super();
}
   public Employe(int id, String name, int salary, String post) {
	super();
    this.Id=id;
	this.name = name;
	this.salary = salary;
	this.post = post;
}
   
   @Override
public String toString() {
	return "Employe [Id=" + Id + ", name=" + name + ", salary=" + salary + ", post=" + post + "]";
}
   public int getId() {
	return Id;
   }
   public void setId(int id) {
	Id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public int getSalary() {
	return salary;
   }
   public void setSalary(int salary) {
	this.salary = salary;
   }
   public String getPost() {
	return post;
   }
   public void setPost(String post) {
	this.post = post;
   }
}
