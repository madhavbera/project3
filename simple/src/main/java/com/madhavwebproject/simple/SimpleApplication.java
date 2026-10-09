package com.madhavwebproject.simple;

import org.hibernate.mapping.UserDefinedArrayType;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Entities.Bca;
import com.Entities.Btech;
import com.Entities.Course;
import com.Entities.Department;
import com.Entities.Employe;
import com.Entities.Example;
import com.madhavwebproject.simple.repo.Bcarepo;
import com.madhavwebproject.simple.repo.Btechrepo;
import com.madhavwebproject.simple.repo.Deptrepo;
import com.madhavwebproject.simple.repo.Details;
import com.madhavwebproject.simple.repo.Emprepo;
import com.madhavwebproject.simple.repo.examprepo;

//import com.madhavwebproject.entity.Bca;
//import com.madhavwebproject.entity.Branch1;
//import com.madhavwebproject.entity.Branch2;
//import com.madhavwebproject.simple.repo.BcaRepo;
//import com.madhavwebproject.simple.repo.Repo1;


import jakarta.annotation.PostConstruct;

//import com.madhavwebproject.Repository.Userrepo;

@SpringBootApplication
@ComponentScan(basePackages = { "com.GlobalException","com.madhavwebproject.controller",
		"com.madhavwebproject.service","com.madhavwebproject.simple.security","com.madhavwebproject.simple.userdetails"
})
//@EnableJpaRepositories(basePackages = {""})
@EntityScan({"com.Entities"})

public class SimpleApplication {
    
	@Autowired
	Bcarepo repo;
	
	@Autowired
	Details dt;
	
	@Autowired
	Btechrepo Brepo;
	
	@Autowired
	Deptrepo Drepo;
	
	@Autowired
	Emprepo emrepo;
	
	@Autowired
	examprepo emprepo;
	

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}
	@PostConstruct
	public void init()
	{
//		//For learner table
//     repo.save(new Bca("Madhav"));
//     repo.save(new Bca("Hasnain"));
//     repo.save(new Bca("Vivek"));
//     repo.save(new Bca("Azam"));
     
     //For Branch table
     
//     dt.save(new Course("BCA"));
//     dt.save(new Course("BCA"));
//     dt.save(new Course("B tech"));
//     dt.save(new Course("BCA"));
//		Bca b=new Bca();
//		
//		Brepo.save(new Btech("vivek"));
//		Brepo.save(new Btech("jaoul"));
//		Brepo.save(new Btech("Gopal"));
//		Brepo.save(new Btech("sham"));
//		
		Department d=new Department();
		Department d1=new Department();
		Department d2=new Department();
		Department d3=new Department();
		d.setId(1);
		d1.setId(2);
		d2.setId(3);
		d3.setId(4);
		d.setDepat_name("IT");
		d1.setDepat_name("DP");
		d2.setDepat_name("CS");
		d3.setDepat_name("HR");
		
		Drepo.save(d);
		Drepo.save(d1);
		Drepo.save(d2);
		Drepo.save(d3);


//		Drepo.save(new Department(d));
//		Drepo.save(new Department(2,"HR"));
//		Drepo.save(new Department(3,"CS"));
//		Drepo.save(new Department(4,"CI"));
		
//		emrepo.save(new Employe(101,"Gopal",));
//		
		Employe em=new Employe();
		Employe em1=new Employe();
		em.setId(101);
		em1.setId(102);
		em.setDept(d);
		em1.setDept(d3);
		em.setName("Gopal");
		em1.setName("Madhav");
		emrepo.save(em);
		emrepo.save(em1);
		
//		emprepo.save(new Example("Gopal Bera","software engineer",100000));
//		emprepo.save(new Example("Madhav bera ","software engineer",50000));
//		emprepo.save(new Example("Shivham bera","Mechanical engineer",50000));
//		emprepo.save(new Example("Sasti Bera"," Bank manager",50000));
  }

}
