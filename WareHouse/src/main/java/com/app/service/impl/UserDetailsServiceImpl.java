package com.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDAO;
import com.app.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserDAO dao;
		
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//find username by using Email
		User user=dao.findByUserEmail(username);
		
		//set GrantedAuthority inset collection
		Set<GrantedAuthority> grantedauthorities=new HashSet<>();
		
		//set the roles of username in SimpleGrantedAuthority
		for(String role:user.getRoles()) {
			grantedauthorities.add(new SimpleGrantedAuthority(role));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), grantedauthorities);
	}

}
