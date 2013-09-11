package com.madrone.lms.form;

import java.util.Calendar;

import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Leave;

public class LeaveCorrectionForm {
	
	private String deptId;
	private String deptDesc;
	
	private Department Dept;
	private Leave leaveTypes;
	private Leave leaveDates;
	
	private String leaveType;
	private Calendar fromDate;
	private Calendar toDate;
	
	
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
	

}
