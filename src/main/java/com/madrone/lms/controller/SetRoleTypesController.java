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
import com.madrone.lms.entity.Role;
import com.madrone.lms.form.RoleTypeForm;
import com.madrone.lms.form.UserForm;
import com.madrone.lms.service.RoleService;
import com.madrone.lms.utils.JSONUtils;

@Controller
public class SetRoleTypesController {
	@Autowired
	private RoleService roleService;

	@Autowired
	private MessageSource messageSource;

	private static final Logger logger = LoggerFactory
			.getLogger(ChangePasswordController.class);

	@RequestMapping(value = "/setRole", method = RequestMethod.GET)
	public String setRoleTypeForm(Model model, UserForm Userform) {
		createJason(model);
		model.addAttribute("roleTypeForm", new RoleTypeForm());
		return LMSConstants.ADMIN_SET_ROLE_SCR;
	}
	
	@RequestMapping(value = "/submitRole", method = RequestMethod.POST)
	public String submitRole(Model model,
			@ModelAttribute("RoleTypeForm") RoleTypeForm form,
			BindingResult result, Map<String, Object> map) {
		
		Role r = roleService.setBeanValuesForSave(form);
		switch (form.getUserAction()) {
			case LMSConstants.INSERT: {
				try {
					roleService.saveRole(r);
					createJason(model);
					model.addAttribute("SucessMessage", messageSource.getMessage(
							"lms.setrole.add.success_message",
							new Object[] { "" }, Locale.getDefault()));
				} catch (Exception e) {
					createJason(model);
					model.addAttribute("FailureMessage", messageSource.getMessage(
							"lms.setroleTypes.mod.failure_message",
							new Object[] { "" }, Locale.getDefault()));
				}
				break;
			}
			case LMSConstants.DELETE: {
				try {
					roleService.deleteRole(form.getId());
					createJason(model);
					model.addAttribute("SucessMessage", messageSource.getMessage(
							"lms.setrole.del.success_message",
							new Object[] { "" }, Locale.getDefault()));
				} catch (Exception e) {
					createJason(model);
					model.addAttribute("FailureMessage", messageSource.getMessage(
							"lms.setrole.del.failure_message",
							new Object[] { "" }, Locale.getDefault()));
					e.printStackTrace();
				}
				break;
			}
			case LMSConstants.UPDATE: {
				roleService.updateLeave(r);
				createJason(model);
				model.addAttribute("SucessMessage", messageSource.getMessage(
						"lms.setrole.upd.success_message",
						new Object[] { "" }, Locale.getDefault()));
				break;
			}
		}
		return LMSConstants.ADMIN_SET_ROLE_SCR;
	}
	
	private void createJason(Model model){
		List<RoleTypeForm> roleTypes = roleService.getRoleList();
		String jsonString = JSONUtils.convertListToJson(roleTypes);
		model.addAttribute("jsonString", jsonString);
	}

}
