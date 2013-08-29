package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(LeaveForm applyLeaveForm);

	void deleteEmployeeLeave(long id);

	List<LeaveDetailsGrid> getPendingLeaveList(String userName);

	List<LeaveDetailsGrid> getLeaveList(String userName);

	List<LeaveDetailsGrid> getLeaveListOfTeam(String userName, String filterBy);

	void cancelEmployeeLeave(LeaveForm cancelForm);

	void approveEmployeeLeave(LeaveForm approveForm);

	void rejectEmployeeLeave(LeaveForm approveForm);

	
}
