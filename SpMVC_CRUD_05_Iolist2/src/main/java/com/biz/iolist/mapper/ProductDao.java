package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.iolist.model.ProductVO;

public interface ProductDao {

	@Select(" SELECT * FROM tbl_product ")
	public List<ProductVO> selectAll();
	
	@Select(" SELECT * FROM tbl_product WHERE p_code =#{p_code}")
	public ProductVO findByCode(String p_code);

	@Select(" SELECT * FROM tbl_product " 
			+ " WHERE p_name LIKE '%' || #{p_name} || '%' ")
	public List<ProductVO> findByName(String p_name);

	
}



