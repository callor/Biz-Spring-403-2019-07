package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVO {
	private String m_userid;	//	varchar2(15 byte)
	private String m_password;	//	varchar2(64 byte)
	private String m_name;		//	nvarchar2(39 char)
	private String m_email;		//	varchar2(25 byte)
	private String m_tel;		//	varchar2(20 byte)
	private String m_role;		//	varchar2(5 byte)
}
