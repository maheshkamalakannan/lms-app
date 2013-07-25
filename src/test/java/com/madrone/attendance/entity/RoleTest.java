package com.madrone.attendance.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoleTest {

	@Test
	public void testEquality() {
		
		Role r1 = new Role("r1", "role-1");
		Role r2 = new Role("r1", "role-1");
		
		assertEquals(r1, r2);
		assertEquals(r2, r1);
	}
	
	@Test
	public void testToString() {
		
		Role r = new Role("r", "role");
		
		StringBuilder expected = new StringBuilder("Role {")
		.append("id=r, ")
		.append("description=role")
		.append("}");
		
		assertEquals(expected.toString(), r.toString());
	}
}
