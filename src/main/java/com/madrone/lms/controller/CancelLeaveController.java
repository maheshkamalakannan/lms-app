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
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class CancelLeaveController {

	@Autowired
	private EmployeeLeaveService empLeaveService;

	private static final Logger logger = LoggerFactory
			.getLogger(CancelLeaveController.class);

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/cancelLeave", method = RequestMethod.GET)
	public String cancelLeave(Model model, LeaveForm form, HttpSession session) {
		logger.info("Inside cancelLeave()");
		model.addAttribute("CancelLeaveForm", new LeaveForm());

		// Setting values into Cancel - Leave Grid
		String userName = (String) session.getAttribute("sessionUser");
		List<LeaveDetailsGrid> cancelLeaveList = empLeaveService
				.getPendingAndApprovalLeaveList(userName);
		String jsonString = JSONUtils.leaveListGridJSON(cancelLeaveList);
        System.out.println("JSONString===" + jsonString);
		model.addAttribute("jsonString", jsonString);
		return LMSConstants.CANCEL_LEAVE_SCR + "_"
				+ session.getAttribute("sessionRole");
	}

	@RequestMapping(value = "/submitCancelLeave", method = RequestMethod.POST)
	public String submitCancelLeave(Model model,
			@ModelAttribute("cancelLeaveForm") LeaveForm form,
			BindingResult result, Map<String, Object> map) {

		logger.info("submitCancelLeave");
		String jsonString = form.getSelecteddata();
		System.out.println("Cancel--Screen" + jsonString);

		LeaveForm cancelForm = JSONUtils.convertJsonToObjectToClass(jsonString);
		if (cancelForm != null) {
			empLeaveService.cancelEmployeeLeave(cancelForm);
			model.addAttribute("SucessMessage", messageSource.getMessage(
					"lms.cancelLeave_success_message", new Object[] { "" },
					Locale.getDefault()));
		}

		return LMSConstants.CANCEL_LEAVE_SCR;

	}

}
