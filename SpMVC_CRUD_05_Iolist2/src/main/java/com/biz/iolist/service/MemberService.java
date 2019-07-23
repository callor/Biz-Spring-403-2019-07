package com.biz.iolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.MemberDao;

@Service
public class MemberService {

	@Autowired
	MemberDao mDao;
	
	public String check_id(String m_userid) {
		return mDao.check_id(m_userid);
	}
	
}
