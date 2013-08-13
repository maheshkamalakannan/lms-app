package com.madrone.lms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	public static final String pattern = "dd/MM/yyyy";
	
	
	public static Calendar convertStringToCalendar(String stringDate) {
		Calendar cal  = Calendar.getInstance();
		SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
		try {
			cal.setTime(sdfDate.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cal;
	}
	

	public static float calculateDays(Date fdate, Date tdate, String fdSession, String tdSession) {
		float days =0;
		
		if (fdate.equals(tdate)) {
			
			if(fdSession.equals("AM") && tdSession.equals("AM")) {
				days = .5f;
			}
			
			if(fdSession.equals("PM") && tdSession.equals("PM")) {
				days = .5f;
			}
			
			if(fdSession.equals("PM") && tdSession.equals("AM")) {
				days = 0.0f;
				//Alert error message. This combination not allowed.
			}
			
			if(fdSession.equals("AM") && tdSession.equals("PM")) {
				days = 1.0f;
			}
			
		}
		
		//Tdate should greater than Fdate.
		
		if (!fdate.equals(tdate))  { 
			days = daysBetweenFromDateAndTodate(fdate,tdate);
			days = "PM".equals(fdSession) ? days-0.5f : days;
			days = "AM".equals(fdSession) ? days-0.5f : days;
		}
		
		return days;
		
	}

	private static float daysBetweenFromDateAndTodate(Date fdate, Date tdate) {
		return 0;
	}
	

}


