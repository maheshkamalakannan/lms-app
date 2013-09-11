package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveTypeForm;

public interface LeaveService {
	
	Leave findById(String id);

	void saveLeave(LeaveTypeForm leaveTypeForm);

	void deleteLeave(String id);

	List<Leave> getLeaveTypes();

	List<ApplyLeaveFormGrid> getApplyLeaveGridDetails(String userName);

	void updateLeave(LeaveTypeForm form);



}