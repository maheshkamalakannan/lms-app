package com.madrone.lms.service;

import com.madrone.lms.entity.Leave;

public interface LeaveService {
	
	Leave findById(String id);

	void saveLeave(Leave l);

	void deleteLeave(String id);

}