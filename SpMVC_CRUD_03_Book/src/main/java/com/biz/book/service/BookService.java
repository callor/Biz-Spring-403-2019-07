package com.biz.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.dao.BookDao;
import com.biz.book.model.BookVO;

@Service
public class BookService {

	@Autowired
	SqlSession sqlSession;
	
	public List<BookVO> selectAll() {
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		List<BookVO> bookList = bDao.selectAll();
		return bookList;
	}

}
