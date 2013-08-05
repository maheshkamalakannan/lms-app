package com.madrone.lms.service;

import com.madrone.lms.entity.User;

public interface UserService {

	User findById(Long id);
	
	void saveUser(User user);
	
	void deleteUser(String userName);

	User findByUserName(String userName);

	boolean authenticateUser(String userName, String password);

}
