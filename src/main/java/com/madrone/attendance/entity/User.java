package com.madrone.attendance.entity;

public class User {
	
	private long id;
	private String firstName;
	private String lastName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof User) {
			User u = (User) ob;
			
			if(id == u.id && (firstName != null && 
					firstName.equals(u.firstName)) && (lastName != null &&
					lastName.equals(u.lastName))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (firstName != null ? firstName.hashCode()
				: 1 + lastName != null ? lastName.hashCode() : 1);
	}
	
	@Override
	public String toString() {		
		return String.format("FirstName: %s - LastName: %s", 
				firstName, lastName);
	}
	
}
