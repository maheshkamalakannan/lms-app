package com.madrone.attendance.dao;

import com.madrone.attendance.entity.Employee;

public interface EmployeeDao extends AbstractDao<Employee, Long>{

	Employee findByEmailAddress(String primaryEmailAddress);
	
	void saveEmployee(Employee employee);

}
