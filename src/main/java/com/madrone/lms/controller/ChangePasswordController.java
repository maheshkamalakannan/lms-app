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

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.User;
import com.madrone.lms.form.ChangePasswordForm;
import com.madrone.lms.service.UserService;

@Controller
public class ChangePasswordController {
	private static final Logger logger = LoggerFactory
			.getLogger(ChangePasswordController.class);

	@Autowired
	private UserService userService;

	// This function is used in ChangePassword.jsp file
	@RequestMapping(value = "/submitChangePassword", method = RequestMethod.POST)
	public String submitChangePassword(
			Model model,
			@ModelAttribute("ChangePasswordForm") ChangePasswordForm changePassword,
			BindingResult result, Map<String, Object> map) {

		logger.info("Inside submitChangePassword method");

		if (!userService.authenticateUser(changePassword.getUserName(),
				changePassword.getOldPassword())) {
			result.rejectValue("oldPassword",
					"lms.password.oldPassword.notvalid");
		} else {
			User user = userService
					.findByUserName(changePassword.getUserName());
			user.setPassword(changePassword.getNewPassword());
			userService.saveUser(user);
		}
		model.addAttribute("userName", changePassword.getUserName());
		model.addAttribute("empName", changePassword.getEmpName());
		return LMSConstants.CHANGE_PASSWORD_SCR;

	}

}
