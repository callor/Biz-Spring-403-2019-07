package com.biz.bbs.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

	private String menu_id;
	private String main_id;
	private String menu_title;
	private String menu_href;
	
	private List<MenuDto> menu_subs;
	
}
