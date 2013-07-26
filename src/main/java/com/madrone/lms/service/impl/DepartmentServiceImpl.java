package com.madrone.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.DepartmentDao;
import com.madrone.lms.entity.Department;
import com.madrone.lms.service.DepartmentService;

@Service("departmenttService")
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public Department findById(String id) {
		return departmentDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveDepartment(Department d) {
		departmentDao.saveDepartment(d);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteDepartment(String id) {
		Department d = departmentDao.findById(id);
		departmentDao.delete(d);
	}

}
