package com.revature.dao;

import com.revature.pojo.User;

public interface UserDAO {
	
	public void createUser(User user);
	
	public User readUser(String username);

}
