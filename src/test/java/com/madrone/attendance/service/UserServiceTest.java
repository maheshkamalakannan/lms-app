package com.madrone.attendance.service;

import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.madrone.attendance.entity.Employee;
import com.madrone.attendance.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", 
		"classpath:spring/hibernateContext.xml"})
public class UserServiceTest {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;

	private final String employeeId = "100";
    private final String userName = "tom@jerry.com";

    @After
    public void tearDown() throws Exception {
    	if(userService.findByUserName(userName) != null) {
    		userService.deleteUser(userName);
    	}
    	if(employeeService.findById(employeeId) != null) {
    		employeeService.deleteEmployee(employeeId);
    	}
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = createUser();
        User found = userService.findByUserName(user.getUserName());
        Assert.assertEquals(user, found);
        Assert.assertTrue(user.getFailedLoginAttempts() == 0);
    }

    @Test
    public void testSearchUser() throws Exception {
        User u = createUser();
        u = userService.findByUserName(u.getUserName());
        Assert.assertEquals(userName, u.getUserName());
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
    	int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    	
        createUser();
        User u1 = userService.findByUserName(userName);
        Assert.assertNotNull(u1);
        Assert.assertEquals(userName, u1.getUserName());
        Calendar todayDate = u1.getModifiedDate();
        Assert.assertTrue(today == todayDate.get(Calendar.DAY_OF_MONTH));

        Calendar tommDate = (Calendar) todayDate.clone();
        tommDate.add(Calendar.DAY_OF_MONTH, 1); 
        int tomm = tommDate.get(Calendar.DAY_OF_MONTH);
        u1.setModifiedDate(tommDate);
        userService.saveUser(u1);

        User found = userService.findByUserName(userName);
        Assert.assertNotNull(found);
        Assert.assertEquals(userName, u1.getUserName());
        tommDate = u1.getModifiedDate();
        Assert.assertTrue(tomm == tommDate.get(Calendar.DAY_OF_MONTH));
    }
    
    private User createUser() {
    	Employee e = new Employee(employeeId, "tom", "jerry", userName, null);
        User user = new User(userName, "password");
        user.setEmployee(e);
        userService.saveUser(user);
        return user;
    }
}
