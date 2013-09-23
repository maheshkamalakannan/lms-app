package com.madrone.lms.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.madrone.lms.constants.LMSConstants;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.service.EmailService;

public class MailUtils {

	@Autowired
	private EmailService emailService;

	public static String composeEmailSubject(LeaveForm form, HttpServletRequest request, String operation ) {
		
		String baseUrl = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
		
		StringBuffer subject = new StringBuffer();
		subject = subject.append("Hi Kumaravel,\n\n");
		subject.append("Employee: " + form.getEmpId() + " " + form.getEmpName());
		if(operation.equals(LMSConstants.LEAVE_APPLY)){
			subject.append(" has requested for " + form.getLeaveType()+ " for a Period of "+form.getNoOfDays()+" day/s. ");
			subject.append(" From :" + form.getFromDate() +" "+ form.getFromDateSession() +" To:"+ form.getToDate() +" "+form.getToDateSession());
			subject.append("\n\nPlease click the link below to Approve/Reject Leave.\n\n");
			subject.append(baseUrl+LMSConstants.APPROVE_LEAVE_URL);
		}
		else if(operation.equals(LMSConstants.LEAVE_CANCEL)){
			subject.append(" has Cancelled his/her " + form.getLeaveType()+ " for a Period of "+form.getNoOfDays()+" day/s. ");
			subject.append(" From :" + form.getFromDate() +" "+ form.getFromDateSession() +" To:"+ form.getToDate() +" "+form.getToDateSession());
			subject.append("\n\nPlease click the link below to get details.\n\n");
			subject.append(baseUrl+LMSConstants.VIEW_CANCELLED_LEAVES_URL);
		}
		
		subject.append("\n\nThanks\n");
		subject.append("The LMS Team");
		subject.append("\n\n\nThis is a system generated email.");
		subject.append(" Please do not reply to this message." );
		subject.append(" Replies to this message are routed to an unmonitored mailbox.");
		return subject.toString();
	}

}
