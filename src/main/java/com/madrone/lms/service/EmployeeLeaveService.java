package com.madrone.lms.service;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveForm;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(ApplyLeaveForm applyLeaveForm);

	void deleteEmployeeLeave(long id);
}
