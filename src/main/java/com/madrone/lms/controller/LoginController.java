package com.madrone.lms.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.form.LoginForm;

import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.UserService;

@Controller
@SessionAttributes({ "empName", "userName" })
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute("LoginForm", new LoginForm());
		return LMSConstants.LOGIN_MENU;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(Model model,
			@ModelAttribute("LoginForm") LoginForm loginForm,
			BindingResult result, Map<String, Object> map) {

		// loginValidator.validate(login, result);

		if (!userService.authenticateUser(loginForm.getUserName(),
				loginForm.getPassword())) {
			result.rejectValue("password",
					"lms.login.username.and.password.notvalid");
		}

		String returnString = result.hasErrors() ? LMSConstants.LOGIN_MENU
				: employeeService.findMenuOption(loginForm.getUserName());
		logger.info("User Name and password given is correct.");
		map.put("userName", loginForm.getUserName());

		Employee employee = employeeService.findByEmailAddress(loginForm
				.getUserName());
		map.put("empName",
				employee.getFirstName() + " " + employee.getLastName());

		return returnString;
	}


}