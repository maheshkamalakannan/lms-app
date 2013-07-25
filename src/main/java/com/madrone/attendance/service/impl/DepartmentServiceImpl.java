package com.madrone.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.attendance.dao.DepartmentDao;
import com.madrone.attendance.entity.Department;
import com.madrone.attendance.service.DepartmentService;

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
	public void deleteDepartment(String id) {
		Department d = findById(id);
		departmentDao.delete(d);
	}

}
