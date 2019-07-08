package com.biz.sp.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

/*
 * HelloService 클래스를 bean으로 등록하고
 * 사용할수 있도록 해달라
 */
@Service
public class HelloService {

	public String getHello() {
		LocalTime lt = LocalTime.now();
		int gp = lt.getHour();
		String msg = "";
		if(gp >= 6 && gp < 9 ) msg = "좋은아침";
		else if(gp >= 9 && gp < 12) msg = "오전수업시간";
		else if(gp >= 12 && gp < 13) msg = "점심시간";
		else if(gp >= 13 && gp < 17) msg = "오후수업시간";
		else msg = "자유시간";
		return msg;		
	}

}
