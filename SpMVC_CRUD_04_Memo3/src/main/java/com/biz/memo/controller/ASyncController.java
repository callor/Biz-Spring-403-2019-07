package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.model.MemoVO;
import com.biz.memo.service.MemoService;

@Controller
@RequestMapping("/ajax")
public class ASyncController {
	
	@Autowired
	MemoService mService;

	@RequestMapping(value="",method=RequestMethod.GET)
	public String ajax(Model model) {
		
		model.addAttribute("BODY","AJAX");
		return "home";
	}
	
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("BODY","AJAX_FORM");
		return "home";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<MemoVO> memoList = mService.selectAll();
		model.addAttribute("MEMOS",memoList);
		return "body/memo_list";
		
	}
	
	
}
