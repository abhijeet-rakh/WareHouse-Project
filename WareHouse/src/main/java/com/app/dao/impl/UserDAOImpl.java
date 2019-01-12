package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDAO;
import com.app.model.User;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User user) {
		return (Integer) ht.save(user); 
	}

	@Override
	public void updateUser(User user) {
		ht.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
	     User user=new User();
	     user.setUserid(id);
	     ht.delete(user);
	}

	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}

	@Override
	public User getUserById(Integer id) {
		return ht.get(User.class, id);
	}
	
}

