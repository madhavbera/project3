package com.ATM.MANAGEMENT.SYSTEM.demo.cont;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.ATM;
import com.ATM.MANAGEMENT.SYSTEM.demo.entity.UserDTO;
import com.ATM.MANAGEMENT.SYSTEM.demo.entity.Userinfo;
import com.ATM.MANAGEMENT.SYSTEM.demo.repo.Myrepo;
import com.ATM.MANAGEMENT.SYSTEM.demo.repo.Userrepo;
import com.ATM.MANAGEMENT.SYSTEM.demo.service.Contservice;

@RestController
@RequestMapping("/ATM")
public class Mycont {
	@Autowired
	Myrepo repo;
	@Autowired
	Contservice service;
	private final Userrepo repo1;
	private final PasswordEncoder encoder;
	public Mycont(Userrepo repo,PasswordEncoder encoder)
	{
		this.repo1=repo;
		this.encoder=encoder;
	}
	@GetMapping("/open")
	public ResponseEntity<String> getresponse()
	{
		return new ResponseEntity<>("WELCOME TO MY ATM SYSTEM",HttpStatus.OK);
	}
	@PostMapping("/createAccountNo")
	public String create(@RequestBody ATM at)
	{
		repo.save(at);
		return "Account create successfully";
	}
	@PostMapping("/createUserId/{id}")
	public String createUserid(@RequestBody UserDTO dt,@PathVariable int id)
	{
		Userinfo info=new Userinfo();
		info.setId(id);
		info.setName(dt.getName());
		info.setPassword(encoder.encode(dt.getPassword()));
		info.setRoles(dt.getRoles());
		repo1.save(info);
		return "User Id stored successfully";
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/Accessdata/{id}")
	
	public ATM getdata(@PathVariable int id)
	{
		
		return   service.getuserdata(id);
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/evenno")
	public ResponseEntity<?> geteuen(@RequestParam List<Integer> no)
	{
		List<Integer> list=new ArrayList<Integer>();
		for(Integer n:no)
		{
			list.add(n);
		}
		List<Integer> newlist=list.stream().filter(n->n%2==0).collect(Collectors.toList());
		return new ResponseEntity<>(newlist,HttpStatus.OK);
	    
	}

}
