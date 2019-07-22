package com.biz.memo.model;

public class MemberVO {
	
	private String m_userid; // PK
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_tel;
	private String m_role ; // 회원이 어떤 등급을 갖느냐, 관리자, 일반사용
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String m_userid, String m_password, String m_name, String m_email, String m_tel, String m_role) {
		super();
		this.m_userid = m_userid;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_tel = m_tel;
		this.m_role = m_role;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_role() {
		return m_role;
	}
	public void setM_role(String m_role) {
		this.m_role = m_role;
	}
	@Override
	public String toString() {
		return "MemberVO [m_userid=" + m_userid + ", m_password=" + m_password + ", m_name=" + m_name + ", m_email="
				+ m_email + ", m_tel=" + m_tel + ", m_role=" + m_role + "]";
	}
	
	
	
}