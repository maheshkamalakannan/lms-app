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
	
    
    @RequestMapping(value = "/showAddUser", method = RequestMethod.GET)
    public String showAddUserForm(Model model,UserForm Userform) {
    	model.addAttribute("UserForm", new UserForm());
        return "showAddUserScreen";
    }
   
    @RequestMapping(value = "/showDeleteUser", method = RequestMethod.GET)
    public String showDeleteUserForm(Model model,UserForm Userform) {
    	model.addAttribute("UserForm", new UserForm());
        return "showDeleteUserScreen";
    }
   
    @RequestMapping(value = "/showModifyUser", method = RequestMethod.GET)
    public String showModifyUserForm(Model model,UserForm Userform) {
    	model.addAttribute("UserForm", new UserForm());
        return "showModifyUserScreen";
    }
	
}
