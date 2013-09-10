package com.madrone.lms.form;

public class LeaveTypeForm {
	
	private String leaveType;
	private String description;
	private float days;
	
	private String action;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDays() {
		return days;
	}
	public void setDays(float days) {
		this.days = days;
	}

}
