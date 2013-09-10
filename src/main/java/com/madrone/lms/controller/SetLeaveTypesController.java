package com.madrone.lms.controller;

import java.util.List;
import java.util.Map;

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

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class SetLeaveTypesController {
	@Autowired
	private LeaveService leaveService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(ChangePasswordController.class);

	@RequestMapping(value = "/setLeaveType", method = RequestMethod.GET)
	public String setLeaveTypeForm(Model model, UserForm Userform) {
		List<Leave> leaveTypes = leaveService.getLeaveTypes();
		String jsonString = JSONUtils.convertListToJson(leaveTypes);
		model.addAttribute("jsonString", jsonString);
		model.addAttribute("leaveTypeForm", new Leave());
		return LMSConstants.ADMIN_SET_LEAVE_TYPE_SCR;
	}
	
	
	@RequestMapping(value = "/submitSetLeaveType", method = RequestMethod.POST)
	public String submitSetLeaveType(
			Model model,
			@ModelAttribute("leaveTypeForm") Leave leaveTypeForm,
			BindingResult result, Map<String, Object> map) {
		leaveService.saveLeave(leaveTypeForm);
		
		return LMSConstants.ADMIN_SET_LEAVE_TYPE_SCR;
		
	}

}
