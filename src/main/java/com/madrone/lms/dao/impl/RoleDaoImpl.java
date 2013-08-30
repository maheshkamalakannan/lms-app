package com.madrone.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.RoleDao;
import com.madrone.lms.entity.Leave;
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

	@Override
	public Role findByIdWithEmployees(String id) {
		Role r = findById(id);
		
		if(r != null) {
			Hibernate.initialize(r.getEmployees());			
		}		
		return r;
	}
	
	@Override
	public List<Role> getRoleTypes() {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		List<Role> roleTypes = findByCriteria(criterionList);
		return roleTypes;
	}


}
