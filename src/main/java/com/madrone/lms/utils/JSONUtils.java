package com.madrone.lms.utils;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.madrone.lms.form.ApplyLeaveFormGrid;
import com.madrone.lms.form.LeaveDetailsGrid;
import com.madrone.lms.form.LeaveForm;
import com.madrone.lms.form.ViewLeaveRequestForm;

public class JSONUtils {
	
	static final ObjectMapper mapper = new ObjectMapper();
	
	
	//This function used in Apply-leave Screen.
	public static String applyLeaveGridJSON(List<ApplyLeaveFormGrid> gridList ) {
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(gridList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
	
	//This function used in Cancel-leave Screen.
	public static String leaveListGridJSON(List<LeaveDetailsGrid> leaveList) {
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			jsonString = mapper.writeValueAsString(leaveList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}

	//This function used in Cancel-leave Screen.
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
	
	//This Function is used in ViewLeaveRequest controller.
	public static String approveGridJSON(List<ViewLeaveRequestForm> leaveList) {
		String jsonString = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			jsonString = mapper.writeValueAsString(leaveList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
	

}