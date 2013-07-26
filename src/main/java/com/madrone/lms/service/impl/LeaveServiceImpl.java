package com.madrone.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madrone.lms.dao.LeaveDao;
import com.madrone.lms.entity.Leave;
import com.madrone.lms.service.LeaveService;

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
