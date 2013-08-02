package com.madrone.lms.controller;


import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.LoginForm;

import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.UserService;
import com.madrone.lms.service.impl.UserServiceImpl;

@Controller
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(UserServiceImpl.class);
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("LoginForm",new LoginForm());
        return LMSConstants.LOGIN_MENU;
    }
	
	
	 
	 /*@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	    public String authenticate( Model model, LoginForm login) {
	        model.addAttribute("saved", "success");
	        boolean validUser = userService.authenticateUser(login.getUserName(), login.getPassword());
	        logger.info("validUser" + validUser);
	        
	        if(validUser) {
	        	String menuLevel =  employeeService.findMenuOption(login.getUserName());
	        	 logger.info("MenuLevel" + menuLevel);
	        	 return menuLevel;
	        }
	        else { 
	        	//Call validator Framework logics here
	        	return LMSConstants.LOGIN_MENU;
	        }
	        
	    }*/

}