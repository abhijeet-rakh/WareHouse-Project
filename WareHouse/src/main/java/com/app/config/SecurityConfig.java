package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userdetailsservice;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsservice)
		.passwordEncoder(passwordEncoder);
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests()
		.antMatchers("")
		*/
		
	}

}
