package com.madrone.attendance.dao;

import java.util.List;

import com.madrone.attendance.entity.User;

public interface UserDao {

	User findById(String userName);
	
	void saveUser(User user);

	void delete(User user);

	List<User> findUsers(String firstName);

}
