package com.biz.iolist.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberDao {

	@Select(" SELECT m_userid "  
				+ "FROM tbl_member WHERE m_userid = #{m_userid} ")
	public String check_id(String m_userid);
	
}
