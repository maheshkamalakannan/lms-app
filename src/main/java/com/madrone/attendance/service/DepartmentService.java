package com.madrone.attendance.service;

import com.madrone.attendance.entity.Department;

public interface DepartmentService {

	Department findById(String id);

	void saveDepartment(Department d);

	void deleteDepartment(String id);

}
