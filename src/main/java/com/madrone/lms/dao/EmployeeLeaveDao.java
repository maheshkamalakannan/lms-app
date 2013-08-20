package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.EmployeeLeave;


public interface EmployeeLeaveDao extends AbstractDao<EmployeeLeave, Long> {

	List<EmployeeLeave> findLeaveSummary();

}
