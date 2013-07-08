package com.madrone.attendance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.madrone.attendance.entity.User;

@Service("userService")
public interface UserService {

	User findByUserName(String userName);
	
	void saveUser(User user);
	
	void deleteUser(String userName);

	List<User> findUsers(String user);

}
