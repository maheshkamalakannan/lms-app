package com.madrone.attendance.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = 5177316647031047346L;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Date createdDate;
	private Date modifiedDate;
	private LoginInfo loginInfo;
	
	public User() {
	}
	
	public User(String userName, String firstName, String lastName, 
			String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.loginInfo = new LoginInfo(0, false);
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
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
				
		StringBuilder pattern = new StringBuilder("User {")
		.append("userName=%s, ")
		.append("firstName=%s, ")
		.append("lastName=%s, ")
		.append("createdDate=%s, ")
		.append("modifiedDate=%s, ")
		.append("lastLoginDate=%s, ")
		.append("failedLoginAttempts=%d, ")
		.append("isLockout=%s")
		.append("}");
		
		return String.format(pattern.toString(), 
				userName, 
				firstName, 
				lastName,
				createdDate,
				modifiedDate,
				loginInfo.lastLoginDate,
				loginInfo.failedLoginAttempts,
				loginInfo.lockout
				);
	}
	
	static class LoginInfo implements Serializable {
		
		private static final long serialVersionUID = -6561428185019534275L;
		private Date lastLoginDate;
		private int failedLoginAttempts;
		private boolean lockout;
		
		private LoginInfo() {}
		
		private LoginInfo(int failedLoginAttempts, boolean lockout) {
			this.failedLoginAttempts = failedLoginAttempts;
			this.lockout = lockout;
		}
		public Date getLastLoginDate() {
			return lastLoginDate;
		}
		public void setLastLoginDate(Date lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}
		public int getFailedLoginAttempts() {
			return failedLoginAttempts;
		}
		public void setFailedLoginAttempts(int failedLoginAttempts) {
			this.failedLoginAttempts = failedLoginAttempts;
		}
		public boolean isLockout() {
			return lockout;
		}
		public void setLockout(boolean lockout) {
			this.lockout = lockout;
		}
	}
}
