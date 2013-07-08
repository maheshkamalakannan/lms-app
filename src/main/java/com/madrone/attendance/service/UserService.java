package com.madrone.attendance.service;

import java.util.List;

import com.madrone.attendance.entity.User;

public interface UserService {

	User findByUserName(String userName);
	
	void saveUser(User user);
	
	void deleteUser(String userName);

	List<User> findUsers(String firstName);

}
