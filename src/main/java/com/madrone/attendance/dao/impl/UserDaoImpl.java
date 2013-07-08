package com.madrone.attendance.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.UserDao;
import com.madrone.attendance.entity.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, String> 
											implements UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findUsers(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
