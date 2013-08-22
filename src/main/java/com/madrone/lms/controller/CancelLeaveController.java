package com.madrone.lms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.CancelLeaveForm;
import com.madrone.lms.service.EmployeeLeaveService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class CancelLeaveController {

	@Autowired
	private EmployeeLeaveService empLeaveService;

	private static final Logger logger = LoggerFactory
			.getLogger(CancelLeaveController.class);

	@RequestMapping(value = "/cancelLeave", method = RequestMethod.GET)
	public String cancelLeave(Model model, CancelLeaveForm form,
			HttpSession session) {
		logger.info("Inside cancelLeave()");
		model.addAttribute("CancelLeaveForm", new CancelLeaveForm());

		// Setting values into Cancel - Leave Grid
		String userName = (String) session.getAttribute("sessionUser");
		List<EmployeeLeave> cancelLeaveList = empLeaveService
				.getCancelLeaveList(userName);
		String jsonString = JSONUtils.leaveListGridJSON(cancelLeaveList);
		
		model.addAttribute("jsonString", jsonString);
		return LMSConstants.CANCEL_LEAVE_SCR;
	}

}
