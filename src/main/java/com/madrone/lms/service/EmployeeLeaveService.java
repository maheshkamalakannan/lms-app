package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveForm;
import com.madrone.lms.form.CancelLeaveForm;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(ApplyLeaveForm applyLeaveForm);

	void deleteEmployeeLeave(long id);

	List<EmployeeLeave> getCancelLeaveList(String userName);

	List<EmployeeLeave> getLeaveList(String userName);

	
}
