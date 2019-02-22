package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDAO {
	public Integer saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer id);
    public List<User> getAllUser();
    public User getUserById(Integer id);
    public boolean isEmailExist(String type, String userEmail);
    public boolean isMobileExist(String type, String userMobile);
    public User findByUserEmail(String username);
   
}
