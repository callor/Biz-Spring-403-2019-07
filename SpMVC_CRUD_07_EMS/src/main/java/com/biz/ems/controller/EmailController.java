package com.biz.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.model.EmailVO;
import com.biz.ems.service.FileService;
import com.biz.ems.service.SendMailService;

@Controller
@RequestMapping(value="/ems")
public class EmailController {
	
	@Autowired
	SendMailService xMailService;
	
	@Autowired
	FileService fService;
	
	@ModelAttribute("emailVO")
	public EmailVO newEmailVO() {
		return new EmailVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public String list(Model model) {
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("emailVO") EmailVO emailVO,
			Model model) {
		
		emailVO.setEms_send_date("2019-08-08");
		emailVO.setEms_send_time("15:20:00");
		emailVO.setEms_from_email("callor88@naver.com");
		emailVO.setEms_from_name("내멋으로");

		model.addAttribute("emailVO",emailVO);
		model.addAttribute("BODY","WRITE");
		return "home";
	
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(
			@ModelAttribute("emailVO") EmailVO emailVO,
			@RequestParam MultipartFile file1,
			BindingResult result,
			Model model
			) {
		
		String fileName = fService.fileUp(file1);
		emailVO.setEms_file1(fileName);
		xMailService.sendMail(emailVO);
		return "home";
	
	}
}
