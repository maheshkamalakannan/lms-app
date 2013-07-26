package com.madrone.attendance.service;

import com.madrone.attendance.entity.Employee;

public interface EmployeeService {

	Employee findById(String id);
	
	Employee findByIdWithLeaves(String id);
	
	void saveEmployee(Employee e);

	void deleteEmployee(String id);
	
	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);

}
