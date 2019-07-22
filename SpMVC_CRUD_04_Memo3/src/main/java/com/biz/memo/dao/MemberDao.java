package com.biz.memo.dao;

import com.biz.memo.model.MemberVO;

public interface MemberDao {

	public MemberVO findByUserId(String m_userid);
	public MemberVO login(MemberVO memberVO);
	
}
