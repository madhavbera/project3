package com.example.library.management.app.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
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
@EnableWebSecurity
@EnableMethodSecurity
public class Mysecurity {
	@Bean
	public UserDetailsService userservice()
	{
		UserDetails userone=User.withUsername("user1").password(encoder().encode("mypassword")).roles("USER").build();
		UserDetails usertwo=User.withUsername("user2").password(encoder().encode("simplepassword")).roles("USER").build();
		UserDetails userthree =User.withUsername("admin").password(encoder().encode("admin1")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(userone,usertwo,userthree);
	}
	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filter(HttpSecurity http)
	{
		http.csrf(csrfcustomizer->csrfcustomizer.disable());
		http.authorizeHttpRequests(request->request.requestMatchers("/Books/Welcome")
				.permitAll().anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
		
	}

}
