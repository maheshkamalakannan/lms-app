package com.madrone.lms.service;

import com.madrone.lms.entity.EmployeeLeave;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(EmployeeLeave el);

	void deleteEmployeeLeave(long id);
}
