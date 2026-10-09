package com.madhavwebproject.simple.userdetails;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Entities.Userdetails;
import com.madhavwebproject.simple.repo.Userdetailsrepo;

@Service
public class Myuserdetailsnew implements UserDetailsService {
	@Autowired
	Userdetailsrepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Userdetails us=repo.findbyname(username);
     if(us==null)
     {
    	 throw new UsernameNotFoundException("not found");
     }
          return new Myuserdetail(us);

	}

}
