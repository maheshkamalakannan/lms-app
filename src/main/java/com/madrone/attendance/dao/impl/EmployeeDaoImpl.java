package com.madrone.attendance.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.EmployeeDao;
import com.madrone.attendance.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, Long> 
							implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(Employee.class);
	}

	@Override
	public Employee findByEmailAddress(String primaryEmail) {
		List<Employee> employees = findByCriteria(
				Restrictions.eq("primaryEmail", primaryEmail));
				
		if(employees.size() > 1) {
			new AssertionError("Duplicate employee records with same " +
					"primary email address.");
		}
		
		return employees.isEmpty() ? null : employees.get(0);
	}

	@Override
	public void saveEmployee(Employee employee) {
		saveOrUpdate(employee);
	}	
}
