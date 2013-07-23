package com.madrone.attendance.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.UserDao;
import com.madrone.attendance.entity.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<User, Long> 
											implements UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);		
	}

	@Override
	public User findByUserName(String userName) {
		List<User> users = findByCriteria(
				Restrictions.eq("userName", userName));
				
		if(users.size() > 1) {
			new AssertionError("Duplicate user records with same " +
					"userName.");
		}
		
		return users.isEmpty() ? null : users.get(0) ;
	}	
}
