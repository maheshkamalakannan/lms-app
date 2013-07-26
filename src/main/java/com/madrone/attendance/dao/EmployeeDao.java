package com.madrone.attendance.dao;

import com.madrone.attendance.entity.Employee;

public interface EmployeeDao extends AbstractDao<Employee, String>{
	
	Employee findByIdWithLeaves(String id);

	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);
	
	void saveEmployee(Employee employee);

}
