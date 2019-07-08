package com.biz.sp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("add",100 + 200);
		
		return "home";
	}
	
	@RequestMapping(value="my",method=RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("nation","대한민국");
		return "myhome";
		
	}
	
	
	
}
