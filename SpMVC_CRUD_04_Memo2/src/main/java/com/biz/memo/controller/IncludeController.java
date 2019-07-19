package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncludeController {


	@RequestMapping(value="inc1",method=RequestMethod.GET)
	public String m1(Model model) {
		
		// String BODY = "M1"
		// BODY라는 변수에 문자열 M1을 담아서 inform.jsp 한테 보내라
		model.addAttribute("BODY","M1");
		return "inform";
	}

	@RequestMapping(value="inc2",method=RequestMethod.GET)
	public String m2(Model model) {

		// String BODY = "M2"		
		model.addAttribute("BODY","M2");
		return "inform";
	}

	
}
