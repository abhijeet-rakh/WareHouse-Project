package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/*
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userdetailsservice;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsservice)
		.passwordEncoder(passwordEncoder);
		System.out.println("configure(AuthenticationManagerBuilder auth):SecurityConfig"+userdetailsservice);
		System.out.println("PasswortEncoder="+passwordEncoder);
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		System.out.println("configure(HttpSecurity http)");
		
		http.authorizeRequests()
		.antMatchers("/user/**","/login").permitAll()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/signin")
		.defaultSuccessUrl("/shipmenttype/register",true)
		.failureUrl("/login?error=true")
		.permitAll()
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout=true")
		.invalidateHttpSession(true)
		.permitAll()
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;	
		
		
	}

}*/