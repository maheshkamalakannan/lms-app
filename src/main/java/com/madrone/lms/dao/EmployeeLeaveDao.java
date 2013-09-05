package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;


public interface EmployeeLeaveDao extends AbstractDao<EmployeeLeave, Long> {

	List<EmployeeLeave> findLeaveSummary();

	List<EmployeeLeave> getLeaveList(Employee emp);

	List<EmployeeLeave> getPendingLeaveList(Employee emp);

	List<EmployeeLeave> getApprovalLeaveList(Employee emp);
	
	List<EmployeeLeave> getRejectionLeaveList(Employee emp);
	
	List<EmployeeLeave> getCancellationLeaveList(Employee emp);

}
