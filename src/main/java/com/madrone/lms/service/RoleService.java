package com.madrone.lms.service;

import com.madrone.lms.entity.Role;

public interface RoleService {

	Role findById(String id);

	void saveRole(Role d);

	void deleteRole(String id);

}
