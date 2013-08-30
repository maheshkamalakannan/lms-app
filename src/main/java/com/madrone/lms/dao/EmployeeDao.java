package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.User;

public interface EmployeeDao extends AbstractDao<Employee, String>{
	
	Employee findByIdWithLeaves(String id);

	Employee findByEmailAddress(String primaryEmail);
	
	Employee findByEmailAddressWithLeaves(String primaryEmail);
	
	void saveEmployee(Employee employee);

	String findRole(String userName);

	List<Employee> findTeamList(Employee leadEmployee);


}
