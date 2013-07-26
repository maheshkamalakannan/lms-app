package com.madrone.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.attendance.dao.RoleDao;
import com.madrone.attendance.entity.Role;
import com.madrone.attendance.service.RoleService;

@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role findById(String id) {
		return roleDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveRole(Role d) {
		roleDao.saveRole(d);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteRole(String id) {
		Role r = roleDao.findById(id);
		roleDao.delete(r);
	}

}
