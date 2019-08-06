package com.biz.bbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.MenuDao;
import com.biz.bbs.model.MenuDto;

@Service
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
		
	List<MenuDto> menuList ;
	
	
	@Autowired
	public void makeList() {
		menuList = new ArrayList<MenuDto>();
	}

	
	public List<MenuDto> getDBMenu(){
		List<MenuDto> menuList = menuDao.getAllMenu();
		return menuList;
	}
	
	
	public List<MenuDto> makeMenu() {
		
		menuList = new ArrayList<MenuDto>();
		
		// List<MenuDto>
		menuList.add(MenuDto.builder()
		.menu_title("홈")
		.menu_href("/").build());

		menuList.add(MenuDto.builder()
		.menu_title("게시판")
		.menu_href("#").build());

		menuList.add(MenuDto.builder()
		.menu_title("메뉴2")
		.menu_href("/").build());

		menuList.add(MenuDto.builder()
		.menu_title("메뉴3")
		.menu_href("/").build());
		
		menuList.add(MenuDto.builder()
		.menu_title("메뉴4")
		.menu_href("/").build());
		
		List<MenuDto> submenus = new ArrayList<MenuDto>();
		submenus.add(MenuDto.builder()
				.menu_title("글쓰기")
				.menu_href("#").build());

		submenus.add(MenuDto.builder()
				.menu_title("DROP1")
				.menu_href("#").build());
		
		submenus.add(MenuDto.builder()
				.menu_title("DROP2")
				.menu_href("#").build());
		
		menuList.add(MenuDto.builder()
				.menu_title("DROP_M1")
				.menu_href("#")
				.menu_subs(submenus).build());
		
		menuList.add(MenuDto.builder()
		.menu_title("로그인")
		.menu_href("/").build());

		menuList.add(MenuDto.builder()
		.menu_title("회원가입")
		.menu_href("/").build());
		
		return menuList;
	}
	
	public List<MenuDto> makeMenu_2() {
		
		// List<MenuDto> menuList = new ArrayList<MenuDto>();
		
		MenuDto menuDto = new MenuDto();
		menuDto.setMenu_title("홈");
		menuDto.setMenu_href("/");
		menuList.add(menuDto);
		
		menuDto = new MenuDto("2","2","게시판","/bbs/list",null);
		menuList.add(menuDto);
		
		return null;
	}
	
	

}
