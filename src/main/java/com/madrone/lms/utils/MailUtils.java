package com.madrone.lms.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.entity.Employee;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.LoginForm;
import com.madrone.lms.service.EmailService;

public class MailUtils {

	@Autowired
	private EmailService emailService;

	public static String composeEmailSubject(HttpServletRequest request, String operation ) {
		
		String baseUrl = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
		StringBuffer subject = new StringBuffer();
		
		switch(operation){
		
		case LMSConstants.LEAVE_APPLY:{
			LeaveForm form = (LeaveForm) request.getAttribute("LeaveForm");
			subject = subject.append("Hi Kumaravel,\n\n");
			subject.append("Employee: " + form.getEmpName() + " " + form.getEmpId());
			subject.append(" has requested " + form.getLeaveType()+ " for a Period of "+form.getNoOfDays()+" day/s. ");
			subject.append(" From :" + form.getFromDate() +" "+ form.getFromDateSession() +" To:"+ form.getToDate() +" "+form.getToDateSession()+"\n\n");
			subject.append(baseUrl+LMSConstants.APPROVE_LEAVE_URL);
			break;
		}
		case LMSConstants.LEAVE_CANCEL:{
			LeaveForm cancelform = (LeaveForm) request.getAttribute("LeaveForm");
			subject        = subject.append("Hi Kumaravel,\n\n");
			subject.append("Employee: " + cancelform.getEmpName() + " " + cancelform.getEmpId());
			subject.append(" has Cancelled his/her " + cancelform.getLeaveType()+ " for a Period of "+cancelform.getNoOfDays()+" day/s. ");
			subject.append(" From :" + cancelform.getFromDate() +" "+ cancelform.getFromDateSession() +" To:"+ cancelform.getToDate() +" "+cancelform.getToDateSession());
			subject.append("\n\nPlease click the link below to get details.\n\n");
			subject.append(baseUrl+LMSConstants.VIEW_CANCELLED_LEAVES_URL);
			break;
		}
		case LMSConstants.FORGOT_PASSWORD:{
			LoginForm loginform  = (LoginForm) request.getAttribute("LoginForm");
			Employee emp    = (Employee) request.getAttribute("Employee");
			String username = emp.getFirstName();
			subject = subject.append("Hi "+username+ ",\n");
			subject.append("\nYou recently asked to reset your LMS password. Please use the link below to create a new password.\n\n");
			subject.append("If the button or link above does not automatically hyperlink, just copy and paste the link text into your browser bar. This link will expire in five hours.\n\n");
			subject.append(baseUrl+LMSConstants.RESET_PASSWORD_URL+"?"+loginform.getUserName());
			break;
		}
		case LMSConstants.CHANGE_PASSWORD:{
			Employee emp    = (Employee) request.getAttribute("Employee");
			subject = subject.append("Hi "+emp.getFirstName()+ ",\n");
			subject.append("\nYou've successfully created a new password for your LMS account. You can visit your LMS account here: \n\n");
			subject.append(baseUrl+LMSConstants.LMS_URL);
			break;
		}
	  }
		subject.append("\n\nThanks\n");
		subject.append("The LMS Team");
		subject.append("\n\n\nThis is a system generated email.");
		subject.append(" Please do not reply to this message." );
		subject.append(" Replies to this message are routed to an unmonitored mailbox.");
		return subject.toString();
	}

}
