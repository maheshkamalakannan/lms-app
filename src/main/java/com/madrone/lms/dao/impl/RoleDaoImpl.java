package com.madrone.lms.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.RoleDao;
import com.madrone.lms.entity.Role;

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
