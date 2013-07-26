package com.madrone.lms.dao.impl;

import org.springframework.stereotype.Repository;

import com.madrone.lms.dao.LeaveDao;
import com.madrone.lms.entity.Leave;

@Repository("leaveDao")
public class LeaveDaoImpl extends AbstractDaoImpl<Leave, String>
						implements LeaveDao {

	protected LeaveDaoImpl() {
		super(Leave.class);
	}
}
