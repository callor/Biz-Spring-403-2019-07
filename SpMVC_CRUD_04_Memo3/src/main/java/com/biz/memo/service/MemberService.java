package com.biz.memo.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.dao.MemberDao;
import com.biz.memo.model.MemberVO;

@Service
public class MemberService {

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberService.class);

	@Autowired
	SqlSession sqlSession;
	
	MemberDao mDao;
	
	@Autowired
	public void getMapper() {
		mDao = sqlSession.getMapper(MemberDao.class);
	}

	public MemberVO login(MemberVO memberVO) {

		String m_userid = memberVO.getM_userid();
		String m_password = memberVO.getM_password();
		
		// memberVO = mDao.findByUserId(m_userid);
		// if(memberVO.getM_password().equals(m_password)) {
			// login 성공
		// }

		// id와 비번을 모드 select 문으로 조회해서
		// 회원 정보 가저요기
		// 만약 id와 비번이 일치하면 정상적인 VO를 리턴
		// 그렇지 않으면 null값을 리턴
		memberVO = mDao.login(memberVO);
		logger.debug("MEMBERVO: " + memberVO);
		return memberVO;
	}
	
}
