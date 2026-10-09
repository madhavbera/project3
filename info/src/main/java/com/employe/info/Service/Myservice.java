package com.employe.info.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.employe.info.JavaException.ExceptionHandeler;
import com.employe.info.Zentity.Employe;
import com.employe.info.webrepo.Myrepo;
import com.employe.info.webrepo.Myrepo1;

//import java. lang.RuntimeException;
//import com.employe.info.ExceptionHandeler;
@Service
public class Myservice {
	@Autowired
	Myrepo repo;
	@Autowired
	Myrepo1 repo1;
	public List<com.employe.info.Zentity.Employe> getall()
	{
		return repo.findAll();
	}
	public com.employe.info.Zentity.Employe getbyid(int id)
	{
	 Employe st =repo.findById(id)
				.orElseThrow(()->new ExceptionHandeler(
						"Id is not found at "+id
						)
						);
	 System.out.println("Return Employee:"+st);
		return st;
		
	}
	public List<com.employe.info.Zentity.Student> getdisplay()
	{
		return repo1.findAll();
	}

}
 
