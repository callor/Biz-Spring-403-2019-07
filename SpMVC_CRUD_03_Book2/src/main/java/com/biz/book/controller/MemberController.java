package com.biz.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.book.model.MemberVO;
import com.biz.book.service.MemberService;

@Controller
public class MemberController {

	@Autowired	
	MemberService mService;

	// join form(회원가입폼)을 보여주기 위한 메서드
	@RequestMapping(value="join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY","JOIN");
		return "home";
	}
	
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO memberVO,
							Model model) {

		mService.insert(memberVO);
		
		model.addAttribute("MEMBER",memberVO);
		model.addAttribute("BODY","MEMBER-VIEW");
		return "home";

	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY","LOGIN");
		return "home";
	}

	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam String m_userid, 
					@RequestParam String m_password,
				Model model,
				HttpSession httpSession) {
		
		boolean bUser = mService.member_check(m_userid, m_password);
		
		// if(bUser) model.addAttribute("USERID",m_userid);
		
		MemberVO memberVO = mService.findByUserId(m_userid);
		if(bUser) httpSession.setAttribute("USER",memberVO);
		
		// model.addAttribute("BODY","LOGIN");
		return "home";
	
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		// session 제거
		httpSession.removeAttribute("USER");
		
		// 특정 session만 null값으로 초기화
		httpSession.setAttribute("USER", null);
		
		return "home";
	}
	

	
	
}
