package com.biz.memo.model;

public class MemoVO {
	private long mo_seq;
	private String mo_date;
	private String mo_time;
	private String mo_auth;
	private String mo_subject;
	private String mo_memo;
	private String mo_file;
	
	public MemoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemoVO(long mo_seq, String mo_date, String mo_time, String mo_auth, String mo_subject, String mo_memo,
			String mo_file) {
		super();
		this.mo_seq = mo_seq;
		this.mo_date = mo_date;
		this.mo_time = mo_time;
		this.mo_auth = mo_auth;
		this.mo_subject = mo_subject;
		this.mo_memo = mo_memo;
		this.mo_file = mo_file;
	}
	public long getMo_seq() {
		return mo_seq;
	}
	public void setMo_seq(long mo_seq) {
		this.mo_seq = mo_seq;
	}
	public String getMo_date() {
		return mo_date;
	}
	public void setMo_date(String mo_date) {
		this.mo_date = mo_date;
	}
	public String getMo_time() {
		return mo_time;
	}
	public void setMo_time(String mo_time) {
		this.mo_time = mo_time;
	}
	public String getMo_auth() {
		return mo_auth;
	}
	public void setMo_auth(String mo_auth) {
		this.mo_auth = mo_auth;
	}
	public String getMo_subject() {
		return mo_subject;
	}
	public void setMo_subject(String mo_subject) {
		this.mo_subject = mo_subject;
	}
	public String getMo_memo() {
		return mo_memo;
	}
	public void setMo_memo(String mo_memo) {
		this.mo_memo = mo_memo;
	}
	public String getMo_file() {
		return mo_file;
	}
	public void setMo_file(String mo_file) {
		this.mo_file = mo_file;
	}
	@Override
	public String toString() {
		return "MemoVO [mo_seq=" + mo_seq + ", mo_date=" + mo_date + ", mo_time=" + mo_time + ", mo_auth=" + mo_auth
				+ ", mo_subject=" + mo_subject + ", mo_memo=" + mo_memo + ", mo_file=" + mo_file + "]";
	}
	
	
	
	
}
