package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;
import com.biz.iolist.service.IolistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/iolist")
public class IolistController {

	
	@Autowired
	IolistService ioService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {

		// List<IolistVO> iolist = ioService.selectAll();
		
		List<IolistDto> iolist = ioService.selectJoin();
		
		model.addAttribute("IOLIST",iolist);
		return "ajax_body/iolist/list";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(
			@ModelAttribute IolistVO iolistVO,
			Model model) {

		log.debug("IOLIST" + iolistVO.toString());
		
		int ret = ioService.insert(iolistVO);
		return "redirect:/iolist/list";
	}
	
}
