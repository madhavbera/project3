package com.employe.info;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employe.info.webrepo.Myrepo;
import com.employe.info.webrepo.Myrepo1;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
//@ComponentScan(basePackages = "com.employe")
//@RestController
public class InfoApplication {

	@Autowired
	Myrepo repo;
	@Autowired
	Myrepo1 repo1;
	
	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);
	}
// @GetMapping("/hellowserver")
// public String getmap()
// {
//	 return "How can i help you";
// }
	@PostConstruct
	public void init()
	{
		
//		repo.save(new com.employe.info.Zentity.Employe(352,"Gopal Bera",1000000,"Senior post"));
//		repo.save(new com.employe.info.Zentity.Employe(353,"Madhav Bera",80000,"Junior developer"));
//		repo.save(new com.employe.info.Zentity.Employe(354,"Shivam Bera",80000,"Junior developer"));
//	    repo.save(new com.employe.info.Zentity.Employe(355,"Sasti Bera",80000,"Junior developer"));
//        repo1.save(new com.employe.info.Zentity.Student( "Madhav","BCA"));
//		repo1.save(new com.employe.info.Zentity.Student( "Hasnain","BCA"));
//		repo1.save(new com.employe.info.Zentity.Student( "Azam","BCA"));
//		repo1.save(new com.employe.info.Zentity.Student( "Zafer","BCA"));
	}
}
