package com.ATM.MANAGEMENT.SYSTEM.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class Mysecurity {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	{
		http.csrf(csrf->csrf.disable());
		http.authorizeHttpRequests(request->request.requestMatchers("/ATM/createAccountNo","/ATM/createUserId/{id}","/ATM/Accessdata/{id}","/ATM/open").permitAll().anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
		
	}

}
