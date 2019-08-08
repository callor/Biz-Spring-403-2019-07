package com.biz.ems.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmailDao {

	public List<EmailVO> selectAll();
	public EmailVO findBySeq(long ems_seq);
	
	public List<EmailVO> fileByFrom(String ems_from_email);
	public List<EmailVO> fileByTo(String ems_to_email);
	
	/*
	 * 매개변수가 2개 이상일 경우는
	 * 반드시 @Param으로 변수 이름을 명시해 주어야 한다.
	 */
	public List<EmailVO> fileByFromAndTo(
			@Param("ems_from_email") String ems_from_email,
			@Param("ems_to_email") String ems_to_email);
	
	public int insert(EmailVO emailVO);
	public int update(EmailVO emailVO);
	public int delete(long ems_seq);
	
}
