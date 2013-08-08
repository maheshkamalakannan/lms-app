package com.madrone.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.UserService;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
    
	
}
