package com.madrone.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.dao.EmployeeLeaveDao;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.LeaveTransactionForm;

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

	@Override
	public List<EmployeeLeave> getLeaveList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getPendingLeaveList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("leaveStatus",
				LMSConstants.LEAVE_STATUS_PENDING));
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getApprovalLeaveList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("leaveStatus",
				LMSConstants.LEAVE_STATUS_APPROVE));
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getRejectionLeaveList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("leaveStatus",
				LMSConstants.LEAVE_STATUS_REJECT));
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getCancellationLeaveList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.eq("leaveStatus",
				LMSConstants.LEAVE_STATUS_CANCEL));
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getPendingAndApprovalList(Employee employee) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		criterionList.add(Restrictions.in("leaveStatus", new String[] { "P",
				"A" }));
		criterionList.add(Restrictions.eq("employee", employee));
		List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
		return employeeLeaveList;
	}

	@Override
	public List<EmployeeLeave> getLeaveListForAdmin(
			List<Employee> employeeList, LeaveTransactionForm leaveForm) {

		for (Employee e : employeeList) {
			List<Criterion> criterionList = new ArrayList<Criterion>();
			criterionList.add(Restrictions.eq("employee", e));
			if (leaveForm.getLeaveTypes() != null) {
				criterionList.add(Restrictions.eq("leave",
						leaveForm.getLeaveTypes()));
			}

			if (!("".equals(leaveForm.getFromDate()) && "".equals(leaveForm
					.getToDate()))) {
				criterionList.add(Restrictions.between("leave",
						leaveForm.getFromDate(), leaveForm.getToDate()));
			}
			List<EmployeeLeave> employeeLeaveList = findByCriteria(criterionList);
			return employeeLeaveList;
		}

		return null;
	}

}
