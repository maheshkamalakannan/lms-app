package com.madrone.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.entity.EmployeeLeave;

@Repository("employeeLeaveDao")
public class EmployeeLeaveDaoImpl extends AbstractDaoImpl<EmployeeLeave, Long>
						implements EmployeeLeaveDao {

	protected EmployeeLeaveDaoImpl() {
		super(EmployeeLeave.class);
	}

	@Override
	public List<EmployeeLeave> findLeaveSummary() {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
		
	}
}
