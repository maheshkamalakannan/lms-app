package com.madrone.lms.dao;

import com.madrone.lms.entity.Employee;

public interface EmployeeDao extends AbstractDao<Employee, String>{
	
	Employee findByIdWithLeaves(String id);

	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);
	
	void saveEmployee(Employee employee);

}
