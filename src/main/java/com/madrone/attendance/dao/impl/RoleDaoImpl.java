package com.madrone.attendance.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.RoleDao;
import com.madrone.attendance.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDaoImpl<Role, String> 
						implements RoleDao {

	protected RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public void saveRole(Role r) {
		saveOrUpdate(r);
	}

}
