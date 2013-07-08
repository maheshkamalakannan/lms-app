package com.madrone.attendance.entity;

public class User {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public User() {
	}
	
	public User(String userName, String firstName, String lastName, 
			String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob instanceof User) {
			User u = (User) ob;
			
			if((userName != null && 
					userName.equals(u.userName)) && (firstName != null && 
					firstName.equals(u.firstName)) && (lastName != null &&
					lastName.equals(u.lastName))) {
				return true;
			}		
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * (userName != null ? userName.hashCode() : 1 +
				firstName != null ? firstName.hashCode() : 1 + 
				lastName != null ? lastName.hashCode() : 1);
	}
	
	@Override
	public String toString() {		
		return String.format("User [Username: %s, FirstName: %s, LastName: %s]", 
				userName, firstName, lastName);
	}
}
