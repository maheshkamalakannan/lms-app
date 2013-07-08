package com.madrone.attendance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.entity.User;

@Repository
public interface UserDao {

	User findById(String userName);
	
	void saveUser(User user);

	void delete(User user);

	List<User> findUsers(String user);

}
