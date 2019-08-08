package com.biz.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bbs.model.MenuDto;
import com.biz.bbs.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession httpSession) {
		
		log.debug("여기는 홈 메서드 입니다");
		
		List<MenuDto> menuList = menuService.getDBMenu();
		// model.addAttribute("MENUS",menuService.makeMenu());
		
		// model.addAttribute("MENUS",menuList);
		httpSession.setAttribute("MENUS",menuList);
		return "home";
	}

	@RequestMapping(value="menu",method=RequestMethod.GET)
	public String menu(Model model) {
		
		List<MenuDto> menuList = menuService.getDBMenu();
		model.addAttribute("MENUS",menuList);
		return "include/include-header" ;
		
	}
	
	
}
