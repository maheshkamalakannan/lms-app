package com.madrone.lms.service;

import com.madrone.lms.entity.Employee;

public interface EmployeeService {

	Employee findById(String id);
	
	Employee findByIdWithLeaves(String id);
	
	void saveEmployee(Employee e);

	void deleteEmployee(String id);
	
	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);

	String findMenuOption(String userName);
}
