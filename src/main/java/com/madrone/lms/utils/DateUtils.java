package com.madrone.lms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.madrone.lms.entity.LeaveStatusEnum;

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
	
	
	public static Date convertStringToDate(String stringDate) {
		Date now = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
		try {
			now =  sdfDate.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return now;
		
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

	private static int daysBetweenFromDateAndTodate(Date d1, Date d2) {
		  int days =  (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		  return days+1;
	}
	
	
  //Enum populate Example
	public static void main(String args[]) {
	    
		for (LeaveStatusEnum l : LeaveStatusEnum.values()) {
			System.out.println("Description======" + l.description());
			System.out.println("Name ======" + l.name());
			System.out.println("---" + l.valueOf("PENDING_APPROVAL"));
		}
   }
	
	
}


