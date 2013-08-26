package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.ApplyLeaveFormGrid;

public interface LeaveService {
	
	Leave findById(String id);

	void saveLeave(Leave l);

	void deleteLeave(String id);

	List<Leave> getLeaveTypes();

	List<ApplyLeaveFormGrid> getApplyLeaveGridDetails(String userName);



}