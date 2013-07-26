package com.madrone.lms.service;

import com.madrone.lms.entity.Department;

public interface DepartmentService {

	Department findById(String id);

	void saveDepartment(Department d);

	void deleteDepartment(String id);

}
