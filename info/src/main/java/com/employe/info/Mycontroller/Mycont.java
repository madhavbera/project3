package com.employe.info.Mycontroller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employe.info.Service.Myservice;
import com.employe.info.Zentity.Employe;

@RestController
@RequestMapping("/example")
public class Mycont {
    @Autowired
    Myservice service;
	@GetMapping("/hellow")
	public String gethellow()
	{
		return "Hey there what can i help you !";
	}
	@GetMapping("/simple")
	public String getsimple()
	{
		return "Hellow simple pass man for transfer";
	}
	@GetMapping("/information")
	public String getinform()
	{
		return "Resttemplate is a communicater between one microservice to another"
				+ " which helps us for tranfering data easily.";
		
	}
	@GetMapping(value="/All",produces="application/json")
	public List<com.employe.info.Zentity.Employe> getAll()
	{
		return service.getall();
	}
	@GetMapping("/{Id}")
	public ResponseEntity<com.employe.info.Zentity.Employe> getid(@PathVariable int  Id)
	{
	Employe em= service.getbyid(Id);
    System.out.println("Return Employee:"+em);
	return ResponseEntity.ok(em);
	}
	@GetMapping("/getAll")
	public List<com.employe.info.Zentity.Student> getall()
	{
		return service.getdisplay();
	}

}
