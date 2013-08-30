package com.madrone.lms.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Role;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.DepartmentService;
import com.madrone.lms.service.RoleService;
import com.madrone.lms.service.UserService;
import com.madrone.lms.utils.EnumUtils;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	// These functions are used in adminMenu.jsp file
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUserForm(Model model, UserForm Userform) {
		List<Role> roleList = roleService.getRoleList();
		List<Role> reportingToList = roleService.getReportingToList();
		List<Department> deptList = deptService.getDepartmentList();
		List<Department> desigList = EnumUtils.getDesigList();

		model.addAttribute("rolelist", roleList);
		model.addAttribute("repolist", reportingToList);
		model.addAttribute("deptlist", deptList);
		model.addAttribute("desiglist", desigList);
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

	@RequestMapping(value = "/submitAdduser", method = RequestMethod.POST)
	public String submitAdduser(Model model,
			@ModelAttribute("UserForm") UserForm userForm,
			BindingResult result, Map<String, Object> map) {

		logger.info("Inside submitChangePassword method");
		userService.saveUserAndEmployee(userForm);

		model.addAttribute("SucessMessage", messageSource.getMessage(
				"lms.password_changed_successfully", new Object[] { "" },
				Locale.getDefault()));

		return LMSConstants.ADMIN_ADD_USER_SCR;

	}

	@RequestMapping(value = "/submitSearchUser", method = RequestMethod.POST)
	public String searchUser(Model model,
			@ModelAttribute("UserForm") UserForm userForm,
			BindingResult result, Map<String, Object> map) {

		userForm = userService.searchUser(userForm.getSearchEmail());
		if (userForm == null) {
			model.addAttribute("validUser", false);
			result.rejectValue("searchEmail", "lms.modifyuser.invalidemail");
		} else {
			System.out.println("Valid e-mail");
			model.addAttribute("UserForm", userForm);
		}
		return LMSConstants.ADMIN_MODIFY_USER_SCR;

	}
}
