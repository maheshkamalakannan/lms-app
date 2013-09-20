package com.madrone.lms.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.service.EmailService;

public class MailUtils {

	@Autowired
	private EmailService emailService;

	public static String composeApplyLeaveSubject(LeaveForm form, String url) {

		StringBuffer subject = new StringBuffer();
		subject = subject.append("Hi Kumaravel,\n\n");
		subject.append("Employee: " + form.getEmpId() + " " + form.getEmpName());
		subject.append(" has requested requested " + form.getLeaveType()
				+ " For the Period");
		subject.append(" From :" + form.getFromDate() + " To:"
				+ form.getToDate());
		subject.append("\n\nPlease click the link below to Approve/Reject Leave.\n\n");
		subject.append(url);
		subject.append("\n\nThanks\n");
		subject.append("The LMS Team");
		subject.append("\n\n\nThis is a system generated email.");
		subject.append(" Please do not reply to this message." );
		subject.append(" Replies to this message are routed to an unmonitored mailbox.");
		return subject.toString();
	}

}
