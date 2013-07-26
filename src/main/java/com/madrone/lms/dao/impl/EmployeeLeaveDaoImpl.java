package com.madrone.lms.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.entity.EmployeeLeave;

@Repository("employeeLeaveDao")
public class EmployeeLeaveDaoImpl extends AbstractDaoImpl<EmployeeLeave, Long>
						implements EmployeeLeaveDao {

	protected EmployeeLeaveDaoImpl() {
		super(EmployeeLeave.class);
	}
}
