package com.madrone.lms.controller;

import java.util.List;
import java.util.Locale;
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
import com.madrone.lms.form.LeaveTypeForm;
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
		createJason(model);
		model.addAttribute("leaveTypeForm", new LeaveTypeForm());
		return LMSConstants.ADMIN_SET_LEAVE_TYPE_SCR;
	}

	@RequestMapping(value = "/submitSetLeaveType", method = RequestMethod.POST)
	public String submitSetLeaveType(Model model,
			@ModelAttribute("leaveTypeForm") LeaveTypeForm form,
			BindingResult result, Map<String, Object> map) {
		
		Leave l = leaveService.setBeanValuesForSave(form);
		switch (form.getUserAction()) {
			case LMSConstants.INSERT: {
				leaveService.saveLeave(l);
				createJason(model);
				model.addAttribute("SucessMessage", messageSource.getMessage(
						"lms.setleaveTypes.add.success_message",
						new Object[] { "" }, Locale.getDefault()));
				break;
			}
			case LMSConstants.DELETE: {
				/*LMS-087 Adding try/catch to display failuremessage to user if Leave type cannot be deleted Starts */
				try {
					leaveService.deleteLeave(form.getId());
					createJason(model);
					model.addAttribute("SucessMessage", messageSource.getMessage(
							"lms.setleaveTypes.del.success_message",
							new Object[] { "" }, Locale.getDefault()));
				} catch (Exception e) {
					createJason(model);
					model.addAttribute("FailureMessage", messageSource.getMessage(
							"lms.setleaveTypes.del.failure_message",
							new Object[] { "" }, Locale.getDefault()));
					e.printStackTrace();
				}
				/*LMS-087 Adding try/catch to display failuremessage to user if Leave type cannot be deleted Ends */
				break;
			}
			case LMSConstants.UPDATE: {
				leaveService.updateLeave(l);
				createJason(model);
				model.addAttribute("SucessMessage", messageSource.getMessage(
						"lms.setleaveTypes.upd.success_message",
						new Object[] { "" }, Locale.getDefault()));
				break;
			}
		}
		return LMSConstants.ADMIN_SET_LEAVE_TYPE_SCR;
	}
	
	private void createJason(Model model){
		List<Leave> leaveTypes = leaveService.getLeaveTypes();
		String jsonString = JSONUtils.convertListToJson(leaveTypes);
		model.addAttribute("jsonString", jsonString);
	}

}
