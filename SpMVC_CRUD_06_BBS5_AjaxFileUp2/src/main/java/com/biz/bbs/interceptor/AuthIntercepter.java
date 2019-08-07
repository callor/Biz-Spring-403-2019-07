package com.biz.bbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.bbs.model.MemberVO;

public class AuthIntercepter extends HandlerInterceptorAdapter {

	/*
	 * Service에 있는 method를 사용해서
	 * 어떤 기능을 수행하고 싶을때는
	 * Controller에서 사용하는 방법으로 구현이 가능하다.
	 */
//	@Autowired
//	BBsService bService;
//	
//	@Autowired
//	MemberService mService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		
		/*
		 * login 등 처리를 하기 위해서는 
		 * HttpSession 클래스를 사용해야 하는데
		 * Controller에서 처럼 매개변수로 처리하여 사용이 불가능하다
		 * request의 getSession() 메서드를 사용하여 session정보를 추출
		 */
		HttpSession httpSession = request.getSession();
		MemberVO memberVO = (MemberVO)httpSession.getAttribute("LOGIN");
		if(memberVO == null) {
			
			response.sendRedirect("/bbs/member/login?LOGIN_MSG=LOGIN");
		
			// Controller로 제어권 전달하지 않고 종료
			return false;
			
		}
		
		// 누가 나를 불렀니?
		// /bbs/write
		// String url = request.getRequestURL().toString();
		// String uri = request.getRequestURI().toString();
	
		// log.debug("REQ_URL : " + url);
		// log.debug("REQ_URI : " + uri);
		
		// 제어권을 Controller로 제어권 전달
		// return super.preHandle(request, response, handler);
		return true;
	
	}
 
	
	
	
}
