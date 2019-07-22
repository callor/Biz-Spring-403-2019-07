package com.biz.memo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.memo.model.MemoVO;
import com.biz.memo.service.FileUpService;
import com.biz.memo.service.MemoService;

@Controller
@RequestMapping(value="/memo")
public class MemoController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MemoController.class);
	
	@Autowired
	MemoService mService;
	
	@Autowired
	FileUpService fService;

		
	@RequestMapping(value="",method=RequestMethod.GET)
	public String memo(Model model) {
		
		
		List<MemoVO> memoList = mService.selectAll();
		model.addAttribute("MEMOS",memoList);
		model.addAttribute("BODY","MEMO");
		return "home";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String memo_write(Model model) {
		model.addAttribute("BODY","MEMO_WRITE");
		return "home";
	}

	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String memo_write(
			@RequestParam("m_file") MultipartFile upFile,
			@ModelAttribute MemoVO memoVO,
			Model model) {
		
		String fileName = fService.fileUp(upFile);
		memoVO.setMo_file(fileName);
		
		int ret = mService.insert(memoVO);
		return "redirect:/memo";
	
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String memo_view(
			@RequestParam long mo_seq,
			Model model) {
		
		MemoVO memoVO = mService.findBySeq(mo_seq);
		logger.debug(memoVO.toString());
		
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_VIEW");
		return "home";
	
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String memo_update(
			@RequestParam long mo_seq,
			Model model) {
		
		MemoVO memoVO = mService.findBySeq(mo_seq);
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_WRITE");
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String memo_update(
			@ModelAttribute MemoVO memoVO,
			Model model) {
		
		int ret = mService.update(memoVO);
		return "redirect:/memo";
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String memo_delete(
			@RequestParam long mo_seq,
			Model model) {
		
		int ret = mService.delete(mo_seq);
		return "redirect:/memo";
	
	}
	
	
	
}
