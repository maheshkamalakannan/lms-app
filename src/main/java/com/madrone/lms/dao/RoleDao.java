package com.madrone.lms.dao;

import com.madrone.lms.entity.Role;

public interface RoleDao extends AbstractDao<Role, String> {

	void saveRole(Role d);

}
