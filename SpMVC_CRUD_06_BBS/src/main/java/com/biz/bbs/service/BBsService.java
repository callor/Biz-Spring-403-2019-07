package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.BBsDao;
import com.biz.bbs.model.BBsVO;

@Service
public class BBsService {

	@Autowired
	BBsDao bDao;
	
	public List<BBsVO> bbsList() {

		List<BBsVO> bbsList = bDao.selectAll();
		return bbsList;
		
	}

	public int insert(BBsVO bbsVO) {

		int ret = bDao.insert(bbsVO);
		return ret;
	}

	public BBsVO getContent(long bbs_seq) {

		BBsVO bbsVO = bDao.findBySeq(bbs_seq);
		return bbsVO;
	}
	
	
}
