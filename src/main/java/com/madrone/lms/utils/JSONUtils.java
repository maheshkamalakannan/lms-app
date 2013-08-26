package com.madrone.lms.utils;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;

public class JSONUtils {
	
	static final ObjectMapper mapper = new ObjectMapper();
	
	
	
	public static String applyLeaveGridJSON(List<ApplyLeaveFormGrid> gridList ) {
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(gridList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
	
	
	public static String leaveListGridJSON(List<EmployeeLeave> leaveList) {
		String jsonString = "";
		List<LeaveDetailsGrid> gridList = new ArrayList<LeaveDetailsGrid>();
		
		ObjectMapper mapper = new ObjectMapper();
		for (EmployeeLeave el : leaveList) {
			LeaveDetailsGrid bean = new LeaveDetailsGrid();
			
			bean.setId(String.valueOf(el.getId()));
			bean.setFromDate(DateUtils.convertCalendarToString(el.getFromDate()));
			bean.setFromDateSession(el.getFromDateSession());
			bean.setToDate(DateUtils.convertCalendarToString(el.getToDate()));
			bean.setToDateSession(el.getToDateSession());
			bean.setLeaveType(el.getLeave().getId());
			bean.setNoOfDays(el.getNoOfDays());
			bean.setStatus(el.getLeaveStatus());
			bean.setReason(el.getReasonForLeave());
			
			gridList.add(bean);
		}
		try {
			jsonString = mapper.writeValueAsString(gridList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}


	public static LeaveForm convertJsonToObjectForCancelLeave(
			String jsonString) {

		jsonString = jsonString.replace("[", "");
		jsonString = jsonString.replace("]", "");
		LeaveForm cancelForm  = null;
		
		try {
				cancelForm  = new ObjectMapper().readValue(jsonString, LeaveForm.class);
		 
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return cancelForm; 
	}
	

}
