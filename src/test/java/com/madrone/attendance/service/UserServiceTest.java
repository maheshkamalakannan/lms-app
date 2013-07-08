package com.madrone.attendance.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.attendance.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
public class UserServiceTest {
	
	@Autowired
    private UserService userService;

    private final String userName = "tomj";

    @After
    public void tearDown() throws Exception {
    	if(userService.findByUserName(userName) != null) {
    		userService.deleteUser(userName);
    	}	
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = createUser();
        User found = userService.findByUserName(user.getUserName());
        Assert.assertEquals(user, found);
    }

    @Test
    public void testSearchUser() throws Exception {
        User u = createUser();
        List<User> users = userService.findUsers(u.getFirstName());
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(userName, users.iterator().next().getUserName());
    }

    @Test
    public void testDeleteUser() throws Exception {
        createUser();
        userService.findByUserName(userName);
        Assert.assertNotNull(userService.findByUserName(userName));
        userService.deleteUser(userName);
        Assert.assertNull(userService.findByUserName(userName));
    }

    @Test
    public void testUpdateUser() throws Exception {
        createUser();
        User u1 = userService.findByUserName(userName);
        Assert.assertNotNull(u1);
        Assert.assertEquals("firstName", u1.getFirstName());
        Assert.assertEquals("lastName", u1.getLastName());

        u1.setFirstName("newFirstName");
        u1.setLastName("newLastName");
        userService.saveUser(u1);

        User found = userService.findByUserName(userName);
        Assert.assertNotNull(found);
        Assert.assertEquals("newFirstName", found.getFirstName());
        Assert.assertEquals("newLastName", found.getLastName());
    }
    
    private User createUser() {
        User user = new User(userName, "firstName", "lastName", "password");
        userService.saveUser(user);
        return user;
    }
}
