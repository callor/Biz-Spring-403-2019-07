package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.iolist.model.ProductVO;
import com.biz.iolist.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	ProductService pService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(@RequestParam String p_name,
			Model model) {

		// List<ProductVO> proList = pService.selectAll();
		
		List<ProductVO> proList = pService.findByName(p_name);
		
		model.addAttribute("PRO_LIST",proList);
	
		return "ajax_body/product/list";
	
	}
	
	
	
}
