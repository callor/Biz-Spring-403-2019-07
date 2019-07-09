package com.biz.input.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(String m_userid, 
			String m_name,String m_password, 
			String m_tel,Model model) {
		
		model.addAttribute("userid",m_userid);
		model.addAttribute("name",m_name);
		model.addAttribute("password",m_password);
		model.addAttribute("tel",m_tel);
		
		return "member_view";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "login_form";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String m_userid, String m_password,Model model) {
		
		model.addAttribute("userid",m_userid);
		model.addAttribute("password",m_password);
		model.addAttribute("name","홍길동님 로그인 성공!!");
		return "member_view";
	}

}
