package com.madrone.lms.service;

import java.util.List;

import com.madrone.lms.entity.Role;

public interface RoleService {

	Role findById(String id);

	Role findByIdWithEmployees(String id);
	
	void saveRole(Role d);

	void deleteRole(String id);

	List<Role> getRoleList();

	List<Role> getReportingToList();

	List<Role> getRoleListHigher(int level);

	int getLevel(String roleId);
}
