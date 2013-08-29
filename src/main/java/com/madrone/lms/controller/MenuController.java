package com.madrone.lms.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.EmployeeHomeForm;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ManagerHomeForm;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.form.ViewLeaveRequestForm;
import com.madrone.lms.form.ViewRejectedLeavesForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.UserService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class MenuController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeLeaveService empLeaveService;

	@RequestMapping(value = "/employeeHome", method = RequestMethod.GET)
	public String employeeHome(Model model, LeaveForm form) {
		model.addAttribute("EmployeeHomeForm", new EmployeeHomeForm());
		return LMSConstants.EMPLOYEE_HOME_SCR;
	}
	
	// These functions are used in managerMenu.jsp file
	@RequestMapping(value = "/managerHome", method = RequestMethod.GET)
	public String managerHome(Model model, LeaveForm form) {
		model.addAttribute("ManagerHomeForm", new ManagerHomeForm());
		return LMSConstants.MANAGER_HOME_SCR;
	}


	// These functions are used in adminMenu.jsp file
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return LMSConstants.ADMIN_ADD_USER_SCR;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return LMSConstants.ADMIN_DELETE_USER_SCR;
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.GET)
	public String modifyUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return LMSConstants.ADMIN_MODIFY_USER_SCR;
	}
	
	@RequestMapping(value = "/setLeaveType", method = RequestMethod.GET)
	public String setLeaveTypeForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return LMSConstants.ADMIN_SET_LEAVE_TYPE_SCR;
	}
	
	@RequestMapping(value = "/viewLeave", method = RequestMethod.GET)
	public String viewLeaveForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return LMSConstants.ADMIN_VIEW_LEAVE_SCR;
	}
	
}
