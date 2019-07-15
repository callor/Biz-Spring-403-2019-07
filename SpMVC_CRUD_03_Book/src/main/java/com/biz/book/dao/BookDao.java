package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {

	public List<BookVO> selectAll();
	
}
