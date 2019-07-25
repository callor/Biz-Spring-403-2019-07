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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession httpSession) {
		
		List<MenuDto> menuList = menuService.getDBMenu();
		// model.addAttribute("MENUS",menuService.makeMenu());
		
		// model.addAttribute("MENUS",menuList);
		httpSession.setAttribute("MENUS",menuList);
		return "home";
	}
}
