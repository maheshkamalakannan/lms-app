package com.madrone.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.ApplyLeaveForm;
import com.madrone.lms.form.CancelLeaveForm;
import com.madrone.lms.form.ChangePasswordForm;
import com.madrone.lms.form.LeaveSummaryForm;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.UserService;

@Controller
public class MenuController {

	@Autowired
	private UserService userService;

	// These functions are used in EmployeeMenu.jsp file
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(Model model, ChangePasswordForm form) {
		model.addAttribute("ChangePasswordForm", new ChangePasswordForm());
		return LMSConstants.CHANGE_PASSWORD_SCR;
	}

	@RequestMapping(value = "/employeeHome", method = RequestMethod.GET)
	public String employeeHome(Model model, ApplyLeaveForm form) {
		model.addAttribute("ApplyLeaveForm", new ApplyLeaveForm());
		return LMSConstants.EMPLOYEE_HOME_SCR;
	}

	@RequestMapping(value = "/applyLeave", method = RequestMethod.GET)
	public String applyLeave(Model model, ApplyLeaveForm form) {
		model.addAttribute("empName", form.getEmpName());
		return LMSConstants.APPLY_LEAVE_SCR;
	}

	@RequestMapping(value = "/cancelLeave", method = RequestMethod.GET)
	public String cancelLeave(Model model, CancelLeaveForm form) {
		model.addAttribute("CancelLeaveForm", new CancelLeaveForm());
		return LMSConstants.CANCEL_LEAVE_SCR;
	}

	@RequestMapping(value = "/leaveSummary", method = RequestMethod.GET)
	public String leaveSummary(Model model, LeaveSummaryForm form) {
		model.addAttribute("LeaveSummaryForm", new LeaveSummaryForm());
		return LMSConstants.LEAVE_SUMMARY_SCR;
	}

	// These functions are used in adminMenu.jsp file
	@RequestMapping(value = "/showAddUser", method = RequestMethod.GET)
	public String showAddUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return "showAddUserScreen";
	}

	@RequestMapping(value = "/showDeleteUser", method = RequestMethod.GET)
	public String showDeleteUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return "showDeleteUserScreen";
	}

	@RequestMapping(value = "/showModifyUser", method = RequestMethod.GET)
	public String showModifyUserForm(Model model, UserForm Userform) {
		model.addAttribute("UserForm", new UserForm());
		return "showModifyUserScreen";
	}

}
