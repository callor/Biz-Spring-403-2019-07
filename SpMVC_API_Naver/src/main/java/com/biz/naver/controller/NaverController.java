package com.biz.naver.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.naver.service.NaverService;

@Controller
@RequestMapping(value="/naver")
public class NaverController {

	@Autowired
	NaverService nService;
	
	
	@RequestMapping(value="/search",
			method=RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	public String naver(
			@RequestParam String category,
			@RequestParam String search_text,
			Model model) {
		
		// String jsonString = nService.getJsonString(category, search_text);
		JSONArray jsonArray = nService.getJsonObject(category, search_text);
		model.addAttribute("NAVERS",jsonArray);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/json",method=RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	public String naver_json() {
	
		String jsonString = nService.getJsonString("BOOK","자바");
		return jsonString;
	}
	
	
}
