package com.madrone.lms.controller;



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
import com.madrone.lms.form.LoginForm;

import com.madrone.lms.service.EmployeeService;
import com.madrone.lms.service.UserService;
import com.madrone.lms.validator.LoginValidator;

@Controller
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginController.class);
	
	LoginValidator loginValidator;
	
	@Autowired
	public LoginController(LoginValidator loginValidator){
		this.loginValidator = loginValidator;
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("LoginForm",new LoginForm());
        return LMSConstants.LOGIN_MENU;
    }
	
	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	 public String authenticate(Model model, @ModelAttribute("LoginForm") LoginForm login,
			 BindingResult result){
		 
         loginValidator.validate(login, result);
         String returnString = result.hasErrors() ?  
         LMSConstants.LOGIN_MENU:employeeService.findMenuOption(login.getUserName());;
         logger.info("User Name and password given is correct."); 
		 return returnString;
	 }     

}