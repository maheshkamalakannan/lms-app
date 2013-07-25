package com.madrone.attendance.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.DepartmentDao;
import com.madrone.attendance.entity.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDaoImpl<Department, String> 
						implements DepartmentDao {

	protected DepartmentDaoImpl() {
		super(Department.class);
	}

	@Override
	public void saveDepartment(Department d) {
		saveOrUpdate(d);		
	}

}
