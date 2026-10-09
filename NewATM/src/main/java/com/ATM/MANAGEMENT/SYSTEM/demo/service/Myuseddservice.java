package com.ATM.MANAGEMENT.SYSTEM.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.Userinfo;
import com.ATM.MANAGEMENT.SYSTEM.demo.repo.Myrepo;
import com.ATM.MANAGEMENT.SYSTEM.demo.repo.Userrepo;

@Service
public class Myuseddservice implements UserDetailsService {
	@Autowired
	Userrepo repo1;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Userinfo info=repo1.findbyname(username);
	if(info==null)
	{
		throw new UsernameNotFoundException("Not found");
	}
		return  new Myuserservice(info);
	}

}
