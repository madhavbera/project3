package com.madhavwebproject.simple.userdetails;

import java.beans.Encoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Entities.Userdetails;

public class Myuserdetail implements UserDetails{
	

	private String name;
	private String password;
	private List<GrantedAuthority> grantedAuthority;
	public Myuserdetail(Userdetails us)
	{
	
		this.name=us.getName();
		this.password=us.getPassword();
	    this.grantedAuthority=Arrays.stream(us.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthority;
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
