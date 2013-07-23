package com.madrone.attendance.dao;

import com.madrone.attendance.entity.User;

public interface UserDao extends AbstractDao<User, Long> {

	void saveUser(User user);

	User findByUserName(String userName);
}
