package com.madrone.lms.dao;

import java.util.List;

import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.CancelLeaveForm;


public interface EmployeeLeaveDao extends AbstractDao<EmployeeLeave, Long> {

	List<EmployeeLeave> findLeaveSummary();

	List<EmployeeLeave> getCancelLeaveList(Employee employee);

}
