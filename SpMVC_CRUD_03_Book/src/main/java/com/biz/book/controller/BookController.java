package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.model.BookVO;
import com.biz.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bService;
	
	@RequestMapping(value="book-view",method=RequestMethod.GET)
	public String book_view(Model model) {
		
		List<BookVO> books = bService.selectAll();
		
		model.addAttribute("BOOKS",books);
		model.addAttribute("BODY","BOOK-LIST");
		return "home";
	}
}



