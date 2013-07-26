package com.madrone.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.service.EmployeeLeaveService;

@Service("employeeLeaveService")
@Transactional(readOnly = true)
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

	@Autowired
	EmployeeLeaveDao employeeLeaveDao;
	
	@Override
	public EmployeeLeave findById(long id) {
		return employeeLeaveDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEmployeeLeave(EmployeeLeave el) {
		employeeLeaveDao.saveOrUpdate(el);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteEmployeeLeave(long id) {
		EmployeeLeave el = findById(id);
		employeeLeaveDao.delete(el);
	}

}
