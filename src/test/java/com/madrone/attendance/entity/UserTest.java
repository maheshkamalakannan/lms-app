package com.madrone.attendance.entity;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void testEquality() {
		
		User u1 = new User();
		u1.setFirstName("peter");
		u1.setLastName("england");
		
		User u2 = new User();
		u2.setFirstName("peter");
		u2.setLastName("england");
		
		Assert.assertEquals(u1, u2);
		Assert.assertEquals(u2, u1);
	}
	
	@Test
	public void testToString() {
		
		User u = new User();
		u.setFirstName("peter");
		u.setLastName("england");
		
		Assert.assertEquals("FirstName: peter - LastName: england", 
				u.toString());
	}
}
