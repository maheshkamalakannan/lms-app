package com.madrone.lms.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApprovedLeaveSummaryForm;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class ApproveLeaveController {
	private static final Logger logger = LoggerFactory
			.getLogger(CancelLeaveController.class);

	@Autowired
	private EmployeeLeaveService empLeaveService;

	@Autowired
	private MessageSource messageSource;
	
	//Show Form for Leave - Approval & Rejection.
	@RequestMapping(value = "/approveLeave", method = RequestMethod.GET)
	public String viewApproveLeave(Model model, ViewLeaveRequestForm form,
			HttpSession session) {
		
		logger.info("Inside ApproveLeave()");
		String userName = (String) session.getAttribute("sessionUser");
		List<LeaveDetailsGrid> leaveListOfTeam = empLeaveService
				.getLeaveListOfTeam(userName,"ALL");
		String jsonString = JSONUtils.convertListToJson(leaveListOfTeam);
		model.addAttribute("jsonString", jsonString);
		model.addAttribute("ViewLeaveRequestForm", new ViewLeaveRequestForm());
		return LMSConstants.MANAGER_VIEW_LEAVE_REQUEST_SCR;
	}
	
	//Submit method for Leave - Approval.
	@RequestMapping(value = "/submitViewLeaveRequest1", method = RequestMethod.POST)
	public String submitForApprove(Model model,
			@ModelAttribute("viewleavereq") ViewLeaveRequestForm form,
			BindingResult result, Map<String, Object> map) {
		logger.info("inside submitViewLeaveRequest()");

		String jsonString = form.getSelecteddata();
		System.out.println("SubmitApproval--Screen" + jsonString);

		LeaveForm approveForm = JSONUtils
				.convertJsonToObjectToClass(jsonString);
		if (approveForm != null) {
			EmployeeLeave el = empLeaveService.setBeanValuesForSave(approveForm);
			empLeaveService.approveEmployeeLeave(el);
			model.addAttribute("SucessMessage", messageSource.getMessage(
					"lms.approveLeave_success_message", new Object[] { "" },
					Locale.getDefault()));
		}

		return LMSConstants.MANAGER_VIEW_LEAVE_REQUEST_SCR;
	}

	// Submit method for Leave - Rejection
	@RequestMapping(value = "/submitViewLeaveRequest2", method = RequestMethod.POST)
	public String submitForReject(Model model,
			@ModelAttribute("viewleavereq") ViewLeaveRequestForm form,
			BindingResult result, Map<String, Object> map) {
		logger.info("inside submitViewLeaveRequest()");

		String jsonString = form.getSelecteddata();

		LeaveForm approveForm = JSONUtils
				.convertJsonToObjectToClass(jsonString);
		if (approveForm != null) {
			EmployeeLeave el = empLeaveService.setBeanValuesForSave(approveForm);
			empLeaveService.rejectEmployeeLeave(el);
			model.addAttribute("SucessMessage", messageSource.getMessage(
					"lms.rejectLeave_success_message", new Object[] { "" },
					Locale.getDefault()));
		}

		return LMSConstants.MANAGER_VIEW_LEAVE_REQUEST_SCR;
	}

}
