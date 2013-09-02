package com.madrone.lms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.RoleDao;
import com.madrone.lms.entity.Role;
import com.madrone.lms.service.RoleService;

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
	public Role findByIdWithEmployees(String id) {
		return roleDao.findByIdWithEmployees(id);
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

	@Override
	public List<Role> getRoleList() {
		return roleDao.getRoleTypes();
	}

	@Override
	public List<Role> getReportingToList() {
		List<Role> roleList = roleDao.getRoleTypes();
		List<Role> returnList = new ArrayList<Role>();
		for (Role r : roleList) {
			if (r.getLevel() != 1) {
				returnList.add(r);
			}
		}
		return returnList;
	}


	@Override
	public int getLevel(String roleId) {
		return roleDao.getLevel(roleId);
	}

	@Override
	public List<Role> getRoleListHigher(int level) {
		return roleDao.getRoleListHigher(level);
	}

}
