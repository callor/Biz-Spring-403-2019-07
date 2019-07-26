package com.biz.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.bbs.model.BBsDto;
import com.biz.bbs.model.BBsVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/bbs")
public class BBsController {

	@Autowired
	BBsService bbsService;
	
	@Autowired
	FileService fileService;

	/*
	 * 현재의 controller내의 어떤 메서드에서
	 * BBsVO를 객체로 취급하여 값을 setter, getter 하려고 시도할때
	 * 만약 객체가 초기화 되지 않아 NullPointException이 발생하려고 하면
	 * 이 메서드가 자동으로 호출되어 bbsVO 객체를 생성 및 초기화 한다
	 */
	@ModelAttribute("bbsVO")
	public BBsVO newBBsVO() {
		return new BBsVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		List<BBsVO> bbsList = bbsService.bbsList();
		
		model.addAttribute("LIST",bbsList);
		model.addAttribute("BODY","BBS_LIST");
		return "home";
		
	}

	@RequestMapping(value="/album",method=RequestMethod.GET)
	public String album(Model model) {
		
		List<BBsDto> bbsList = bbsService.bbsListForFile();
		
		model.addAttribute("LIST",bbsList);
		model.addAttribute("BODY","BBS_ALBUM");
		return "home";
		
	}

	
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(
			@ModelAttribute("bbsVO") BBsVO bbsVO, 
			Model model) {
		
		// LocalDate ld = LocalDate.now();
		// LocalTime lt = LocalTime.now();
		
		LocalDateTime ldt = LocalDateTime.now();
		String curDate 
		= ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
		
		String curTime
		= ldt.format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString();
		
		bbsVO.setBbs_date(curDate);
		bbsVO.setBbs_time(curTime);
		model.addAttribute("bbsVO",bbsVO);
		
		model.addAttribute("BODY","BBS_WRITE");
		return "home";
		
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write_up(
			@ModelAttribute BBsVO bbsVO,
			// @RequestParam("bbs_file") List<MultipartFile> bbs_file,
			Model model) {
		
//		log.debug("파일개수:" + bbs_file.size());
//		for(MultipartFile f : bbs_file) {
//			log.debug("파일명 : " + f.getOriginalFilename() );
//		}
		
		int ret = bbsService.insert(bbsVO);
		return "redirect:/bbs/list";
	
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(
			@RequestParam long bbs_seq,
			Model model) {
		
		BBsDto bbsDto = bbsService.getContent(bbs_seq);

		model.addAttribute("BBS",bbsDto);
		model.addAttribute("BODY","BBS_VIEW");
		
		return "home";
		
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(
			@RequestParam long bbs_seq, 
			Model model) {
		
		BBsDto bbsDto = bbsService.getContent(bbs_seq);
		model.addAttribute("bbsVO",bbsDto);
		model.addAttribute("BODY","BBS_WRITE");
		return "home";
		
	}
	
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(
			@ModelAttribute BBsVO bbsVO,
			Model model) {
		
		int ret  = bbsService.update(bbsVO);
		return "redirect:/bbs/list";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/file_delete")
	public String file_delete(long file_seq) {
		
		boolean okDelete = fileService.file_delete(file_seq);
		if(okDelete) return "OK";
		else return "FAIL";

	}

		
}
