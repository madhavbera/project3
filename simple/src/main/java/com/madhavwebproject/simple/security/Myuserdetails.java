package com.madhavwebproject.simple.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
@EnableWebSecurity

public class Myuserdetails {
	
	
	@Autowired
	UserDetailsService detailsService;
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user1=User.withUsername("user1").password(encoder().encode("1234")).roles("USER")
//				.build();
//		UserDetails user2=User.withUsername("user2").password(encoder().encode("pass2")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user1,user2);
//				
//	}
	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	{
		http.csrf(csrfcustomizer->csrfcustomizer.disable());
		http.authorizeHttpRequests(request->request.requestMatchers("/map/hellow","/map/Insertdata/{id}").permitAll().anyRequest()
				.authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();	
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider(detailsService);
		authenticationProvider.setPasswordEncoder(encoder());
		return authenticationProvider;
	}

}
