package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDAO {
	public Integer saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer id);
    public List<User> getAllUser();
    public User getUserById(Integer id);
}
