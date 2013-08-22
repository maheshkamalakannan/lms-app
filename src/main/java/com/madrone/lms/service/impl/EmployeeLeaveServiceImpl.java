package com.madrone.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.dao.EmployeeDao;
import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.ApplyLeaveForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.DateUtils;

@Service("employeeLeaveService")
@Transactional(readOnly = true)
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

	@Autowired
	EmployeeLeaveDao empLeaveDao;

	@Autowired
	EmployeeDao empDao;

	@Override
	public EmployeeLeave findById(long id) {
		return empLeaveDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteEmployeeLeave(long id) {
		EmployeeLeave el = findById(id);
		empLeaveDao.delete(el);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveEmployeeLeave(ApplyLeaveForm applyLeaveForm) {

		EmployeeLeave el = new EmployeeLeave();
		Employee e = empDao.findById(applyLeaveForm.getEmpId());
		el.setEmployee(e);

		Leave l = new Leave();
		l.setId(applyLeaveForm.getLeaveType());
		el.setLeave(l);

		el.setFromDate(DateUtils.convertStringToCalendar(applyLeaveForm
				.getFromDate()));
		el.setToDate(DateUtils.convertStringToCalendar(applyLeaveForm
				.getToDate()));
		el.setFromDateSession(applyLeaveForm.getFromDateSession());
		el.setToDateSession(applyLeaveForm.getToDateSession());
		el.setNoOfDays(applyLeaveForm.getNoOfDays());
		el.setReasonForLeave(applyLeaveForm.getReason());
		el.setEmergencyPhoneNumber(applyLeaveForm.getEmergencyPhone());
		el.setLeaveStatus(LMSConstants.LEAVE_STATUS_PENDING);

		empLeaveDao.saveOrUpdate(el);
	}

	@Override
	public List<EmployeeLeave> getCancelLeaveList(String userName) {
		Employee emp = empDao.findByEmailAddress(userName);
		return empLeaveDao.getCancelLeaveList(emp);
	}

}
