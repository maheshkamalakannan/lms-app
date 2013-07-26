package com.madrone.attendance.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.EmployeeLeaveDao;
import com.madrone.attendance.entity.EmployeeLeave;

@Repository("employeeLeaveDao")
public class EmployeeLeaveDaoImpl extends AbstractDaoImpl<EmployeeLeave, Long>
						implements EmployeeLeaveDao {

	protected EmployeeLeaveDaoImpl() {
		super(EmployeeLeave.class);
	}
}
