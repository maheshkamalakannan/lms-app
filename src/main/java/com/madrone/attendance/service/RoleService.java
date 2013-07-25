package com.madrone.attendance.service;

import com.madrone.attendance.entity.Role;

public interface RoleService {

	Role findById(String id);

	void saveRole(Role d);

	void deleteRole(String id);

}
