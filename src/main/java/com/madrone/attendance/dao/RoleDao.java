package com.madrone.attendance.dao;

import com.madrone.attendance.entity.Role;

public interface RoleDao extends AbstractDao<Role, String> {

	void saveRole(Role d);

}
