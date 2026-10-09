package com.ATM.MANAGEMENT.SYSTEM.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ATM.MANAGEMENT.SYSTEM.demo.entity.Userinfo;

public class Myuserservice implements UserDetails{
	private String name;
	private String password;
	private List<GrantedAuthority> grantedAuthorities;
	public Myuserservice(Userinfo info)
	{
		this.name=info.getName();
		this.password=info.getPassword();
		this.grantedAuthorities=Arrays.stream(info.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

}
