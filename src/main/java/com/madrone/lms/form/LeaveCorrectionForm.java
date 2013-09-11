package com.madrone.lms.form;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Leave;

public class LeaveCorrectionForm {
	
	private String deptId;
	private String deptDesc;
	
	private Department Dept;
	private Leave leaveTypes;
	private Leave leaveDates;
	
	private String leaveType;
	private String fromDate;
	private String toDate;
	
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public Department getDept() {
		return Dept;
	}
	public void setDept(Department dept) {
		Dept = dept;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public Leave getLeaveTypes() {
		return leaveTypes;
	}
	public void setLeaveTypes(Leave leaveTypes) {
		this.leaveTypes = leaveTypes;
	}
	public Leave getLeaveDates() {
		return leaveDates;
	}
	public void setLeaveDates(Leave leaveDates) {
		this.leaveDates = leaveDates;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	

}
