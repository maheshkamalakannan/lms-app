package com.madrone.attendance.service;

import com.madrone.attendance.entity.EmployeeLeave;

public interface EmployeeLeaveService {

	EmployeeLeave findById(long id);
	
	void saveEmployeeLeave(EmployeeLeave el);

	void deleteEmployeeLeave(long id);
}
