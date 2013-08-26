package com.madrone.lms.form;

import java.util.Calendar;

public class ViewLeaveRequestForm {

	private String empId;
	private String empName;
	private Calendar fromDate;
	private Calendar toDate;
	private String leaveReson;
	private String approvalComment;
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Calendar getFromDate() {
		return fromDate;
	}
	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}
	public Calendar getToDate() {
		return toDate;
	}
	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}
	public String getLeaveReson() {
		return leaveReson;
	}
	public void setLeaveReson(String leaveReson) {
		this.leaveReson = leaveReson;
	}
	public String getApprovalComment() {
		return approvalComment;
	}
	public void setApprovalComment(String approvalComment) {
		this.approvalComment = approvalComment;
	}
	
	
}
