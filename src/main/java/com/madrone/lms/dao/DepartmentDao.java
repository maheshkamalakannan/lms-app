package com.madrone.lms.dao;

import com.madrone.lms.entity.Department;

public interface DepartmentDao extends AbstractDao<Department, String> {

	void saveDepartment(Department d);

}
