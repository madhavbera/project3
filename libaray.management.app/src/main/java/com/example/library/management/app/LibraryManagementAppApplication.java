package com.example.library.management.app;



import org.springframework.beans.factory.annotation.Autowired;




//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.library.management.app.entities.Account;
import com.example.library.management.app.entities.Book;
import com.example.library.management.app.repo.Accrepo;
import com.example.library.management.app.repo.Bookrepo;

//import com.example.library_management_app.Entities.Book;
//import com.example.library_management_app.Repositorys.BookRepository;

//import jakarta.annotation.PostConstruct;

//import com.example.library.entity.Book;
//import com.example.library.management.app.repo.BookRepo;


@SpringBootApplication

@ComponentScan(basePackages = "Exception")
@ComponentScan(basePackages = {"com.example.library.management.app.controller","com.example.library.management.app.entities"
		,"com.example.library.management.app.repo","com.example.library.management.app.service","com.example.library.management.app.security"}
)
public class LibraryManagementAppApplication  {
	@Autowired
	Bookrepo repo;
	@Autowired
	Accrepo repo1;
	
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementAppApplication.class, args);
    }

//    @Bean
//    @PostConstruct
//   public void  init(){
       
//            repo.save(new Book("Java Programming","James Gosling"));
//            repo.save(new Book("C Programming","Deniss Retche"));
//            repo.save(new Book("Python Programming","Guido van rossume"));
//            repo.save(new Book("Javasript Programming"," Something"));
//        repo1.save(new Account(101,"Gopal Bera","gopalbera78@gmail.com",0.0,6789));
//        repo1.save(new Account(102,"Madhav Bera","madhavbera98@gmail.com",0.0,8998));
//        repo1.save(new Account(103,"Shivham Bera","shivhambera88@gmail.com",0.0,4567));
//        repo1.save(new Account(104,"Sasti Bera","sastibera72@gmail.com",0.0,2391));
//    }
}