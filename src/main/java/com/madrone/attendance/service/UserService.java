package com.madrone.attendance.service;

import com.madrone.attendance.entity.User;

public interface UserService {

	User findById(Long id);
	
	void saveUser(User user);
	
	void deleteUser(String userName);

	User findByUserName(String userName);

}
