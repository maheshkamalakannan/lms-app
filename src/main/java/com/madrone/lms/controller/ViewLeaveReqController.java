package com.madrone.lms.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.ViewLeaveRequestForm;
import com.madrone.lms.service.EmployeeLeaveService;


@Controller
public class ViewLeaveReqController {
	private static final Logger logger = LoggerFactory
			.getLogger(CancelLeaveController.class);
			
	@Autowired
	private EmployeeLeaveService empLeaveService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/approveLeave", method = RequestMethod.GET)
	public String viewApproveLeave(Model model, ViewLeaveRequestForm form) {
		System.out.println("inside");
		model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
		return LMSConstants.MANAGER_VIEW_LEAVE_REQUEST_SCR;
	}
	
	
}
