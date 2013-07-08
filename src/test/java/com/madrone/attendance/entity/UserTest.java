package com.madrone.attendance.entity;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void testEquality() {
		
		User u1 = new User();
		u1.setFirstName("peter");
		u1.setLastName("england");
		u1.setUserName("peter.e@madronesoft.com");
		
		User u2 = new User();
		u2.setFirstName("peter");
		u2.setLastName("england");
		u2.setUserName("peter.e@madronesoft.com");
		
		Assert.assertEquals(u1, u2);
		Assert.assertEquals(u2, u1);
	}
	
	@Test
	public void testToString() {
		
		User u = new User();
		u.setFirstName("peter");
		u.setLastName("england");
		u.setUserName("peter.e@madronesoft.com");
		
		Assert.assertEquals("User [Username: peter.e@madronesoft.com, " +
				"FirstName: peter, LastName: england]", 
				u.toString());
	}
}
