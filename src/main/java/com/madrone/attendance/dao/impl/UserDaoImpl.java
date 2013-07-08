package com.madrone.attendance.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.UserDao;
import com.madrone.attendance.entity.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<User, String> 
											implements UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);		
	}

	@Override
	public List<User> findUsers(String firstName) {
		return findByCriteria(
				Restrictions.like("firstName", firstName, MatchMode.START));
	}
	
}
