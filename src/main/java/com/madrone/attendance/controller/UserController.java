package com.madrone.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.madrone.attendance.service.UserService;

@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	// TODO
}
