package com.madrone.attendance.service;

import com.madrone.attendance.entity.Leave;

public interface LeaveService {
	
	Leave findById(String id);

	void saveLeave(Leave l);

	void deleteLeave(String id);

}