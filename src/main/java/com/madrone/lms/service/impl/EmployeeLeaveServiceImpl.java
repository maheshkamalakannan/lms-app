package com.madrone.lms.service.impl;

import java.util.ArrayList;
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
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;
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
	public void saveEmployeeLeave(LeaveForm applyLeaveForm) {
		EmployeeLeave el = setBeanValues(applyLeaveForm);
		el.setLeaveStatus(LMSConstants.LEAVE_STATUS_PENDING);

		empLeaveDao.saveOrUpdate(el);
	}

	@Override
	@Transactional(readOnly = false)
	public void cancelEmployeeLeave(LeaveForm applyLeaveForm) {
		EmployeeLeave el = setBeanValues(applyLeaveForm);
		el.setLeaveStatus(LMSConstants.LEAVE_STATUS_CANCEL);
		empLeaveDao.saveOrUpdate(el);
	}

	@Override
	public List<EmployeeLeave> getLeaveList(String userName) {
		Employee emp = empDao.findByEmailAddress(userName);
		return empLeaveDao.getLeaveList(emp);
	}

	@Override
	public List<ViewLeaveRequestForm> getLeaveListOfTeam(String userName) {
		Employee leadEmployee = empDao.findByEmailAddress(userName);
		List<Employee> teamList = empDao.findTeamList(leadEmployee);
		List<ViewLeaveRequestForm> teamLeaveList = new ArrayList<ViewLeaveRequestForm>();

		for (Employee emp : teamList) {
			List<EmployeeLeave> leaveList = empLeaveDao
					.getPendingLeaveList(emp);

			for (EmployeeLeave el : leaveList) {
				ViewLeaveRequestForm bean = new ViewLeaveRequestForm();
				bean.setEmpId(el.getEmployee().getId());
				bean.setEmpName(el.getEmployee().getFirstName());
				bean.setFromDateSession(el.getFromDateSession());
				bean.setFromDate(DateUtils.convertCalendarToString(el
						.getFromDate()));
				bean.setToDate(DateUtils.convertCalendarToString(el
						.getFromDate()));
				bean.setToDateSession(el.getToDateSession());
				bean.setLeaveReason(el.getReasonForLeave());
				bean.setLeaveType(el.getLeave().getId());
				bean.setNoOfDays(el.getNoOfDays());
				bean.setStatus(el.getLeaveStatus());
				teamLeaveList.add(bean);
			}
		}

		return teamLeaveList;
	}

	@Override
	public List<LeaveDetailsGrid> getPendingLeaveList(String userName) {
		Employee emp = empDao.findByEmailAddress(userName);
		List<EmployeeLeave> leaveList = empLeaveDao.getPendingLeaveList(emp);
		List<LeaveDetailsGrid> returnList = new ArrayList<LeaveDetailsGrid>();
		
		if(leaveList!=null && leaveList.size()>0) { 
			for (EmployeeLeave el : leaveList) {
				LeaveDetailsGrid bean = new LeaveDetailsGrid();
				bean.setId(String.valueOf(el.getId()));
				bean.setFromDate(DateUtils.convertCalendarToString(el.getFromDate()));
				bean.setFromDateSession(el.getFromDateSession());
				bean.setToDate(DateUtils.convertCalendarToString(el.getToDate()));
				bean.setToDateSession(el.getToDateSession());
				bean.setLeaveType(el.getLeave().getId());
				bean.setNoOfDays(el.getNoOfDays());
				bean.setStatus(el.getLeaveStatus());
				bean.setReason(el.getReasonForLeave());
				returnList.add(bean);
			}
		}
		return returnList;
	}

	private EmployeeLeave setBeanValues(LeaveForm leaveForm) {

		EmployeeLeave el = new EmployeeLeave();
		Employee e = empDao.findById(leaveForm.getEmpId());
		el.setEmployee(e);

		Leave l = new Leave();
		l.setId(leaveForm.getLeaveType());
		el.setLeave(l);

		el.setId(leaveForm.getId());

		el.setFromDate(DateUtils.convertStringToCalendar(leaveForm
				.getFromDate()));
		el.setToDate(DateUtils.convertStringToCalendar(leaveForm.getToDate()));
		el.setFromDateSession(leaveForm.getFromDateSession());
		el.setToDateSession(leaveForm.getToDateSession());
		el.setNoOfDays(leaveForm.getNoOfDays());
		el.setReasonForLeave(leaveForm.getReason());
		el.setEmergencyPhoneNumber(leaveForm.getEmergencyPhone());

		return el;

	}

}
