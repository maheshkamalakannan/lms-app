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
import com.madrone.lms.entity.Department;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.form.LeaveCorrectionForm;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.DepartmentService;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.service.LeaveService;
import com.madrone.lms.utils.JSONUtils;
import com.madrone.lms.utils.JsonResponse;


//This is for admin users, who can able to view and edit leave records.
@Controller
public class LeaveCorrectionController {
	@Autowired
	private EmployeeLeaveService empLeaveService;
	
	@Autowired
	private DepartmentService depService;
	
	@Autowired
	private LeaveService leaveService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApprovedRejectedListController.class);
	
	@RequestMapping(value = "/viewLeave", method = RequestMethod.GET)
	public String viewLeaveForm(Model model, UserForm Userform) {
		loadComboValues(model);
		return LMSConstants.ADMIN_VIEW_LEAVE_SCR;
	}
	
	private void loadComboValues(Model model) {
		List<Department> deptList = depService.getDepartmentList();
		model.addAttribute("deptList", deptList);
		
		List<Leave> ltList = leaveService.getLeaveTypes();
		model.addAttribute("leaveTypes", ltList);
		
		model.addAttribute("LeaveCorrectionForm", new LeaveCorrectionForm());
		
	}

	@RequestMapping(value = "/searchLeaveCorrection", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse searchUser(Model model,
			@ModelAttribute("LeaveCorrectionForm") LeaveCorrectionForm lForm, BindingResult result) {
		JsonResponse res = new JsonResponse();
		
		logger.info("Inside submitLeaveTransaction()");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService.getLeaveListForAdmin(lForm);
		
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		model.addAttribute("jsonString",jsonString);
		res.setResult(leaveListOfTeam);
		loadComboValues(model);

		return res;
	}
	

}
