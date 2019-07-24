package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.MemberDao;
import com.biz.iolist.model.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {

	@Autowired
	MemberDao mDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public String check_id(String m_userid) {
		return mDao.check_id(m_userid);
	}

	public int insert(MemberVO memberVO) {

		// plan text : 평문
		String strPassword = memberVO.getM_password();
		
		// crypt text : 암호화된 문자열
		String cryptPassword = passwordEncoder.encode(strPassword);
		log.debug("비밀번호:" 
					+ strPassword + " : " 
					+ cryptPassword);	
		
		memberVO.setM_password(cryptPassword);
		
		
		/*
		 * 최초로 가입되는 회원에게 ADMIN 권한을 부여하고
		 * 이후 부터는 USER 권한을 부여한다.
		 */
		List<MemberVO> memList = mDao.selectAll();
		if(memList.size() > 0) memberVO.setM_role("USER");
		else memberVO.setM_role("ADMIN");
				
		int ret = mDao.insert(memberVO);
		return ret;
	}

	public MemberVO login_check(MemberVO memberVO) {

		// vo를 통째로 보내고 id 를 체크하여 vo를 return
		MemberVO re_memberVO = mDao.login_id_check(memberVO);
		
		// vo에서 userid만 추출하여 보내고 id를 체크하여 vo를 return
		// re_memberVO = mDao.login_id_check(memberVO.getM_userid());
		
		// 해당하는 id가 없다
		// re_memberVO == null
		if(re_memberVO != null) { // id가 일치하는 회원 정보가 있으면
		
			// 암호화 되어서 저장된 비밀번호
			String cryptPassword = re_memberVO.getM_password();
			
			// 로그인할때 입력한 비밀번호
			String strPassword = memberVO.getM_password();
			
			// 평문비번과 암호화된 비번을 비교
			if(passwordEncoder.matches(strPassword, cryptPassword)) {
				// true 이면 비번이 일치했다
				return re_memberVO;
			} else {
				return null;
			}
			
		}
		return null;
		
	}
	
}
