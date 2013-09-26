package com.madrone.lms.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.entity.User;
import com.madrone.lms.form.ChangePasswordForm;
import com.madrone.lms.form.LoginForm;
import com.madrone.lms.service.EmailService;
import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.UserService;
import com.madrone.lms.utils.MailUtils;

@Controller
public class ChangePasswordController {
	private static final Logger logger = LoggerFactory
			.getLogger(ChangePasswordController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(Model model, ChangePasswordForm form,
			HttpSession session) {
		model.addAttribute("ChangePasswordForm", new ChangePasswordForm());
		return LMSConstants.CHANGE_PASSWORD_SCR + "_"
				+ session.getAttribute("sessionRole");

	}

	@RequestMapping(value = "/submitChangePassword", method = RequestMethod.POST)
	public ModelAndView submitChangePassword(@ModelAttribute("ChangePasswordForm") ChangePasswordForm changePassword,
			                           BindingResult result, Map<String, Object> map, HttpSession session,
			                           RedirectAttributes ra, HttpServletRequest request) {

		logger.info("Inside submitChangePassword method");
		ModelAndView modelView = new ModelAndView(new RedirectView(LMSConstants.CHANGE_PASSWORD_URL));

		if (!userService.authenticateUser(changePassword.getUserName(),
				changePassword.getOldPassword())) {
			ra. addFlashAttribute("FailureMessage", messageSource.getMessage(
					"lms.password.oldPassword.notvalid", new Object[] { "" },
					Locale.getDefault()));
		} else {
			User user = userService
					.findByUserName(changePassword.getUserName());
			user.setPassword(changePassword.getNewPassword());
			userService.saveUser(user);
			Employee employee = employeeService.findByEmailAddress(changePassword.getUserName());
			request.setAttribute("Employee", employee);
			String mailSubject 	 = MailUtils.composeEmailSubject(request,LMSConstants.CHANGE_PASSWORD);
			String from 		 = (String) session.getAttribute("sessionUser");;
			emailService.sendMail(from,changePassword.getUserName(),"Change Password success ", mailSubject);
			ra. addFlashAttribute("SucessMessage", messageSource.getMessage(
					"lms.password_changed_successfully", new Object[] { "" },
					Locale.getDefault()));
		}

		ra. addFlashAttribute("userName", changePassword.getUserName());
		ra. addFlashAttribute("empName", changePassword.getEmpName());
		return modelView;

	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(Model model,
			@ModelAttribute("ForgotPasswordForm") LoginForm loginForm,
			BindingResult result, Map<String, Object> map, 
			HttpSession session) {
		return LMSConstants.FORGOT_PASSWORD_SCR;
	}
	
	@RequestMapping(value = "/submitForgotPassword", method = RequestMethod.POST)
	public ModelAndView submitApplyLeave(
			@ModelAttribute("ForgotPasswordForm") LoginForm loginForm,
			BindingResult result, Map<String, Object> map, HttpSession session,
			RedirectAttributes ra, HttpServletRequest request) {

		ModelAndView modelView = new ModelAndView(new RedirectView(LMSConstants.FORGOT_PASSWORD_URL));
		try {
			Employee employee = employeeService.findByEmailAddress(loginForm.getUserName());
			System.out.println("Email "+employee.getPrimaryEmail());
			if(employee != null){
				request.setAttribute("LoginForm", loginForm);
				request.setAttribute("Employee", employee);
				String mailSubject 	 = MailUtils.composeEmailSubject(request,LMSConstants.FORGOT_PASSWORD);
				String from 		 = (String) session.getAttribute("sessionUser");
				emailService.sendMail(from,employee.getPrimaryEmail(),"Forgot Password", mailSubject);
				ra.addFlashAttribute("SucessMessage", messageSource.getMessage("lms.forgotpassword.success_message", new Object[] { "" },Locale.getDefault()));
			}
		} catch (Exception e) {
			ra.addFlashAttribute("FailureMessage", messageSource.getMessage("lms.forgotpassword.failue_message", new Object[] { "" },Locale.getDefault()));
		}
		return modelView;
	}
}
