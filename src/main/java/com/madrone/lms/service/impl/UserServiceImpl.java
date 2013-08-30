package com.madrone.lms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.EmployeeDao;
import com.madrone.lms.dao.UserDao;
import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.Role;
import com.madrone.lms.entity.User;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.UserService;
import com.madrone.lms.utils.DateUtils;
import com.madrone.lms.utils.EnumUtils;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private EmployeeDao empDao;

	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		if (user != null) {
			Employee e = empDao.findByEmailAddress(user.getUserName());

			// Temporary code. Shall be removed after binding the HR module
			// with the LMS module.
			// if Employee does not exist, create employee on the fly
			if (e == null) {
				empDao.saveEmployee(user.getEmployee());
			}

			userDao.saveUser(user);
			logger.info("Successfully saved " + user.toString());
		} else {
			throw new IllegalArgumentException("User object passed is null");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		User user = userDao.findByUserName(userName);
		userDao.delete(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		return userDao.authenticateUser(userName, password);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUserAndEmployee(UserForm userForm) {
		Employee emp = new Employee("011", userForm.getFirstname(),
				userForm.getLastname(), userForm.getEmail(), "",
				DateUtils.convertStringToCalendar(userForm.getDateofjoin()),
				EnumUtils.getDesignation(userForm.getDesig()),
				userForm.getAddress(), "", userForm.getCity(),
				userForm.getState(), userForm.getPincode());

		Department dept = new Department();
		dept.setId(userForm.getDept());
		emp.setDepartment(dept);

		Role role = new Role();
		role.setId(userForm.getRole());
		emp.setRole(role);
		emp.setReporting_to(userForm.getReportingto());

		User user = new User(userForm.getEmail(), userForm.getPassword());
		user.setEmployee(emp);

		empDao.saveEmployee(emp);
		userDao.saveUser(user);

	}

	@Override
	public UserForm searchUser(String searchEmail) {

		Employee emp = empDao.findByEmailAddress(searchEmail);
		UserForm userform = null;
		if (emp == null) {
			return userform;
		} else {
			userform = new UserForm();
			userform.setFirstname(emp.getFirstName());
			userform.setLastname(emp.getLastName());
			userform.setDateofjoin(DateUtils.convertCalendarToString(emp
					.getDateOfJoin()));
			userform.setDept(emp.getDepartment().getId());
			userform.setDesig(emp.getDesignation().name());
			userform.setReportingto(emp.getReporting_to());
			userform.setUserName(emp.getPrimaryEmail());
			userform.setAddress(emp.getAddress().getAddressLine1());
			userform.setState(emp.getAddress().getState());
			userform.setCity(emp.getAddress().getCity());
			userform.setState(emp.getAddress().getState());

			User user = userDao.findByUserName(searchEmail);
			userform.setPassword(user.getPassword());
			return userform;
		}
	}

}
