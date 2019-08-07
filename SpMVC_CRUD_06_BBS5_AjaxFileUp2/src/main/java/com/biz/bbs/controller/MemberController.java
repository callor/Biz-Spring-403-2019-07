package com.biz.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.bbs.model.MemberVO;
import com.biz.bbs.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(
			@RequestParam(value="LOGIN_MSG",
			required = false,
			defaultValue = "") String LOGIN_MSG,
			Model model) {
		
		model.addAttribute("LOGIN_MSG",LOGIN_MSG);
		model.addAttribute("BODY","LOGIN");
		return "home";
	
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@ModelAttribute MemberVO memberVO, 
			Model model,
			HttpSession httpSession) {
		
		String m_userid = memberVO.getM_userid();
		String m_password = memberVO.getM_password();
		memberVO = mService.login_id_check(m_userid,m_password);
		
		if(memberVO != null) {
			httpSession.setAttribute("LOGIN", memberVO);
		} else {
			model.addAttribute("LOGIN_MSG","FAIL");
			return "redirect:/member/login";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(Model model, HttpSession httpSession) {
		
		httpSession.setAttribute("LOGIN", null);
		httpSession.removeAttribute("LOGIN");
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("BODY","JOIN");
		return "home";
	}
	
	
	
	
}
