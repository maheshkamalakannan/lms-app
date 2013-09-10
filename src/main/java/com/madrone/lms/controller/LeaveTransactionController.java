package com.madrone.lms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveTransactionForm;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.JSONUtils;
import com.madrone.lms.utils.JsonResponse;


//This is for admin users, who can able to view and edit leave records.
@Controller
public class LeaveTransactionController {
	@Autowired
	private EmployeeLeaveService empLeaveService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApprovedRejectedListController.class);
	
	@RequestMapping(value = "/viewLeave", method = RequestMethod.GET)
	public String viewLeaveForm(Model model, UserForm Userform) {
		model.addAttribute("LeaveTransactionForm", new LeaveTransactionForm());
		return LMSConstants.ADMIN_VIEW_LEAVE_SCR;
	}
	
	@RequestMapping(value = "/submitLeaveTransaction", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse searchUser(Model model,
			@ModelAttribute("LeaveTransactionForm") LeaveTransactionForm lForm, BindingResult result) {
		JsonResponse res = new JsonResponse();
		
		logger.info("Inside submitLeaveTransaction()");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService.getLeaveListForAdmin(lForm);
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		logger.info("JSONString" + jsonString); 

		return res;
	}
	

}
