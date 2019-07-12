package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.BookVO;
import com.biz.book.service.BookService;

// 클래스의 첫글자 절대 소문자 금지
// BookController bookController = new BookController();
// bookController bookController = new bookController();
@Controller
public class BookController {

	@Autowired
	BookService bService;
	
	@RequestMapping(value="book",method=RequestMethod.GET)
	public String book(Model model) {
		
		/*
		 * TDD(Test Driven Developer)
		 * 
		 * BookService에 아직 생성되지 않은
		 * selectAll() 메서드를 사용하겠다라고 먼저 코드를 작성하고
		 * 오류가 발생을 하면
		 * 이클립스의 코드 자동생성 기능을 이용하여
		 * selectAll() 메서드를 생성하는 방식
		 * 
		 * 시작 : 일단 오류가 발생하지 않는 코드를 만들고
		 * 그리고 : 세부 사항을 작성하는 방식
		 * 
		 */
		List<BookVO> bookList = bService.selectAll();
		
		model.addAttribute("BOOKS",bookList);
		return "book-list";

	}
	
}
