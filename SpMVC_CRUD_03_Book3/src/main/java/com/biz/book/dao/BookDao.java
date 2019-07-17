package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {

	public List<BookVO> selectAll();
	public BookVO findBySeq(long b_seq);
	
	// 도서명, 출판사, 저자로 검색하기
	public List<BookVO> findByTitle(String b_title);
	public List<BookVO> findByComp(String b_comp);
	public List<BookVO> findByAuth(String b_auth);
	
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(long b_seq);
	
}
