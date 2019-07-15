package com.biz.book.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*
	 * logger level
	 * 
	 * ALL, TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF
	 * 
	 * log4j.xml에서
	 * 		만약 log level을 warn 설정하면 
	 * 		ALL,TRACE,DEBUG,INFO를 무시하라
	 * 
	 * 		만약 level을 info 설정하면
	 * 		ALL, TRACE, DEBUG 를 무시하라
	 * 
	 */
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 콘솔을 통해서 어떤 메시지를 표시하거나
		// 변수가 값을 확인하고자 할때는
		// System.ount.println()을 사용하지 말고
		logger.debug("나의 메시지");
		logger.debug("log debug");
		logger.debug("log debug");
		logger.debug(""+ (30+40));
		logger.debug("표시할 값 {}", 30+40);
		logger.debug("표시할 값 {} + {} = {}",30,40);
		
		logger.info("log info");
		logger.warn("log warn");
		
		// model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
}
