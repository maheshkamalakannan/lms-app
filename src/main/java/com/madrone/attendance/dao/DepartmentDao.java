package com.madrone.attendance.dao;

import com.madrone.attendance.entity.Department;

public interface DepartmentDao extends AbstractDao<Department, String> {

	void saveDepartment(Department d);

}
