package com.madrone.lms.form;

import com.madrone.lms.entity.LeaveStatusEnum;

public class ApplyLeaveForm {
	
	private String empId;
	
	private String fromDate;
	private String toDate;
	private String fromDateSession;
	private String toDateSession;
	
	private String leaveType;
	private float noOfDays;
	private String reason;
	private String emergencyPhone;
	private LeaveStatusEnum status;
	
	
	public String getEmpId() {
		return empId;
	}
	public LeaveStatusEnum getStatus() {
		return status;
	}
	public void setStatus(LeaveStatusEnum status) {
		this.status = status;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public float getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(float noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	
	public String getFromDateSession() {
		return fromDateSession;
	}
	public void setFromDateSession(String fromDateSession) {
		this.fromDateSession = fromDateSession;
	}
	public String getToDateSession() {
		return toDateSession;
	}
	public void setToDateSession(String toDateSession) {
		this.toDateSession = toDateSession;
	}

	@Override
	public String toString() {
		return "ApplyLeaveForm [empId=" + empId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}
	
	
	
	
	
}
