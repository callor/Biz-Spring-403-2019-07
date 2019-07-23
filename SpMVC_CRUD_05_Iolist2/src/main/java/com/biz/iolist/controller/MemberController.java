package com.biz.iolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.iolist.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	MemberService mService;

	@ResponseBody
	@RequestMapping(value="/check_id",method=RequestMethod.GET)
	public String check_id(
			@RequestParam String m_userid,
			Model model) {
		return mService.check_id(m_userid);
	}

	
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		return "body/join";
	}

}
