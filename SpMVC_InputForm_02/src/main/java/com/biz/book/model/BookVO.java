package com.biz.book.model;

public class BookVO {
	private String b_title;
	private String b_comp;
	private String b_auth;
	private int b_price;
	
	public BookVO() {
		super();
	}

	public BookVO(String b_title, String b_comp, String b_auth, int b_price) {
		super();
		this.b_title = b_title;
		this.b_comp = b_comp;
		this.b_auth = b_auth;
		this.b_price = b_price;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_comp() {
		return b_comp;
	}
	public void setB_comp(String b_comp) {
		this.b_comp = b_comp;
	}
	public String getB_auth() {
		return b_auth;
	}
	public void setB_auth(String b_auth) {
		this.b_auth = b_auth;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	@Override
	public String toString() {
		return "BookVO [b_title=" + b_title + ", b_comp=" + b_comp + ", b_auth=" + b_auth + ", b_price=" + b_price
				+ "]";
	}
	
	
	
	
}
