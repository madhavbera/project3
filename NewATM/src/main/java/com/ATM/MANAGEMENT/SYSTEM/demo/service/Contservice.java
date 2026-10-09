package com.ATM.MANAGEMENT.SYSTEM.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.ATM;
import com.ATM.MANAGEMENT.SYSTEM.demo.repo.Myrepo;

@Service
public class Contservice {
	@Autowired
	Myrepo repo1;
	
	public ATM getuserdata(int id)
	{
		ATM st=repo1.getatmdata(id);
		return st;
	}

}
