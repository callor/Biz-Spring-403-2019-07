package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.iolist.model.CompVO;

public interface CompDao {

	@Select(" SELECT * FROM tbl_comp ")
	public List<CompVO> selectAll();
	
	@Select(" SELECT * FROM tbl_comp WHERE c_code = #{c_code}")
	public CompVO findByCCode(String c_code);
	
	@Select(" SELECT * FROM tbl_comp " 
			+ " WHERE c_name LIKE '%' || #{c_name} || '%' ")
	public List<CompVO> findByCName(String c_name);
	
	@Select(" SELECT * FROM tbl_comp " 
			+ " WHERE c_tel LIKE '%' || #{c_tel} || '%' ")
	public List<CompVO> findByCTel(String c_tel);
	
	
}
