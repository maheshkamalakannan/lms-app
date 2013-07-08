package com.madrone.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.attendance.dao.UserDao;
import com.madrone.attendance.entity.User;
import com.madrone.attendance.service.UserService;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
    public User findByUserName(String userName) {
        return userDao.findById(userName);
    }
 
    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
 
    @Override
    @Transactional(readOnly = false)
    public void deleteUser(String userName) {
        User user = userDao.findById(userName);
        userDao.delete(user);
    }
 
    @Override
    public List<User> findUsers(String user) {
        return userDao.findUsers(user);
    }
	
}
