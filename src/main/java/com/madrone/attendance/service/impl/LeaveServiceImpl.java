package com.madrone.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.attendance.dao.LeaveDao;
import com.madrone.attendance.entity.Leave;
import com.madrone.attendance.service.LeaveService;

@Service("leaveService")
@Transactional(readOnly = true)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;
	
	@Override
	public Leave findById(String id) {
		return leaveDao.findById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveLeave(Leave l) {
		leaveDao.saveOrUpdate(l);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteLeave(String id) {
		Leave l = leaveDao.findById(id);
		leaveDao.delete(l);
	}

}
