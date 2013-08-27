package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(LeaveForm applyLeaveForm);

	void deleteEmployeeLeave(long id);

	List<EmployeeLeave> getPendingLeaveList(String userName);

	List<EmployeeLeave> getLeaveList(String userName);

	List<ViewLeaveRequestForm> getLeaveListOfTeam(String userName);

	void cancelEmployeeLeave(LeaveForm cancelForm);

	
}
