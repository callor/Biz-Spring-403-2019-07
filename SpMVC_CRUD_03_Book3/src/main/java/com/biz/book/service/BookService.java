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

	public int insert(BookVO bookVO) {
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		int ret = bDao.insert(bookVO);
		return ret;
	}

	public BookVO findBySeq(long b_seq) {
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		BookVO bookVO = bDao.findBySeq(b_seq);
		return bookVO;
	}

	public int delete(long b_seq) {
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		int ret = bDao.delete(b_seq);
		return ret;
	}

	public int update(BookVO bookVO) {
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		int ret = bDao.update(bookVO);
		return ret;
	}

}
