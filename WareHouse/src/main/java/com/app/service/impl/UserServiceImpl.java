package com.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDAO;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO dao;
	
	@Transactional
	public Integer saveUser(User user) {
		return dao.saveUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}

	@Transactional
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	@Transactional
	public User getUserById(Integer id) {
		return dao.getUserById(id);
	}

}
