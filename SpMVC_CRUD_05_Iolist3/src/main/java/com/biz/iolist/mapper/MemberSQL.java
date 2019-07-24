package com.biz.iolist.mapper;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {

	public String member_insert_sql() {
		
		// 무명클래스를 객체로 생성하고, 
		// 값을 초기화 하는 방법
		SQL sql = new SQL() {{
			
			INSERT_INTO("tbl_member"); // TABLE 지정
			INTO_COLUMNS("m_userid")
					.INTO_VALUES("#{m_userid , jdbcType=VARCHAR}");
			VALUES("m_password","#{m_password , jdbcType=VARCHAR}");
			VALUES("m_name, m_tel","#{m_name , jdbcType=VARCHAR},#{m_tel , jdbcType=VARCHAR}");
			INTO_COLUMNS("m_email").INTO_VALUES("#{m_email , jdbcType=VARCHAR}");
			INTO_COLUMNS("m_role").INTO_VALUES("#{m_role , jdbcType=VARCHAR}");
			
		}};
		return sql.toString();
	}
}
