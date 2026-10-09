package com.madhavwebproject.service;

import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Entities.Bca;
import com.Entities.Btech;
import com.madhavwebproject.simple.repo.Bcarepo;
import com.madhavwebproject.simple.repo.Btechrepo;

@org.springframework.stereotype.Service

public class Service {
	@Autowired
	Bcarepo repo;
	@Autowired
	Btechrepo repo1;
	
	public String getvalue(List<Integer> num,int n)
	{
		for(int i=1;i<num.size();i++)
		{
			int temp=num.get(i);
			int j=i-1;
			while(j>=0 && num.get(j)>temp)
			{
				num.set(j+1, num.get(j));
				j--;
				
			}
			num.set(j+1, temp);
			
			
		}
		return"your sorted list "+ num;
	}
	public List<Bca> getfindall()
	{
		return repo.findAll();
	}
    public Bca getbyid(int id)
    {
//    	if(repo.existsById(id))
//    	{
//    		
//    	}
    	return repo.findById(id).orElseThrow(()->new NullPointerException("Not found  id at:"+id));
    }
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<?> Findid(NoSuchElementException ex)
//    {
//    	return ResponseEntity.ok("Id is not found");
//    }
    public Btech getBtechid(int id)
    {
    	return repo1.findById(id).orElseThrow(()->new NullPointerException("ID not found"));
    }
}
