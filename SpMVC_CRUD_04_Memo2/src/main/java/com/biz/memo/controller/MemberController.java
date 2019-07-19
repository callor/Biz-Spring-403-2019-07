package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.model.MemberVO;
import com.biz.memo.service.FileUpService;
import com.biz.memo.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
	MemberService mService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY","LOGIN");
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute MemberVO memberVO,
			Model model,HttpSession httpSession) {
		
		// id와 비번이 담긴 vo를 service에게 주고
		// 모든 정보가 담긴 vo를 다시 받기
		memberVO = mService.login(memberVO);
		if(memberVO != null) 
			httpSession.setAttribute("USER", memberVO);
	
		return "redirect:/" ;
	
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(Model model,HttpSession httpSession) {
		httpSession.setAttribute("USER", null);
		return "redirect:/";
	}
	
}
