package com.madrone.lms.dao.impl;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.DepartmentDao;
import com.madrone.lms.entity.Department;

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

	@Override
	public Department findByIdWithEmployees(String id) {
		Department d = findById(id);
		
		if(d != null) {
			Hibernate.initialize(d.getEmployees());			
		}		
		return d;
	}

}
