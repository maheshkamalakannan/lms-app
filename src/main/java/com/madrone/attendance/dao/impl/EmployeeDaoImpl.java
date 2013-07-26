package com.madrone.attendance.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.EmployeeDao;
import com.madrone.attendance.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, String> 
							implements EmployeeDao {

	public EmployeeDaoImpl() {
		super(Employee.class);
	}
	
	@Override
	public Employee findByIdWithLeaves(String id) {
		Employee e = findById(id);
		
		if(e != null) {
			Hibernate.initialize(e.getEmployeeLeaves());			
		}
		
		return e;
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
	public Employee findByEmailAddressWithLeaves(String primaryEmail) {
		Employee e = findByEmailAddress(primaryEmail);
		
		if(e != null) {
			Hibernate.initialize(e.getEmployeeLeaves());			
		}
		
		return e;
	}
	

	@Override
	public void saveEmployee(Employee employee) {
		saveOrUpdate(employee);
	}	
}
