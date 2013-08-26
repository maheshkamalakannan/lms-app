package com.madrone.lms.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.madrone.lms.entity.EmployeeLeave;
import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.CancelLeaveForm;
import com.madrone.lms.form.LeaveDetailsGrid;

public class JSONUtils {
	
	static final ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String args[]) {
		
		String json = "{\"fromDate\":\"13/08/2013\",\"toDate\":\"15/08/2013\",\"noOfDays\":2,\"leaveType\":\"CL\",\"action\":false,\"status\":\"P\",\"reason\":\"..\"}";
		try {
			CancelLeaveForm form = mapper.readValue(json, CancelLeaveForm.class);
			System.out.println("FromDate" + form.getFromDate());
		} catch (Exception e) {
			e.printStackTrace();
		}

		}
	
	
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
			bean.setFromDate(DateUtils.convertCalendarToString(el.getFromDate()));
			bean.setToDate(DateUtils.convertCalendarToString(el.getToDate()));
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


	public static CancelLeaveForm convertJsonToObjectForCancelLeave(
			String jsonString) {

		jsonString = jsonString.replace("[", "");
		jsonString = jsonString.replace("]", "");
		CancelLeaveForm cancelForm  = null;
		 
		try {
				cancelForm  = new ObjectMapper().readValue(jsonString, CancelLeaveForm.class);
		 
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return cancelForm; 
	}
	

}
