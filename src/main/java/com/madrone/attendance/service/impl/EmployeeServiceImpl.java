package com.madrone.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.attendance.dao.EmployeeDao;
import com.madrone.attendance.entity.Employee;
import com.madrone.attendance.service.EmployeeService;

@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public Employee findById(String id) {
		return empDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEmployee(Employee e) {
		empDao.saveEmployee(e);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteEmployee(String id) {
		Employee e = findById(id);
		empDao.delete(e);		
	}
}
