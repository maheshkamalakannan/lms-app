package com.madrone.attendance.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.attendance.dao.LeaveDao;
import com.madrone.attendance.entity.Leave;

@Repository("leaveDao")
public class LeaveDaoImpl extends AbstractDaoImpl<Leave, String>
						implements LeaveDao {

	protected LeaveDaoImpl() {
		super(Leave.class);
	}
}
