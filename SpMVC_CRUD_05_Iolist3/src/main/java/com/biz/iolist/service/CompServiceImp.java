package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.CompDao;
import com.biz.iolist.model.CompVO;

@Service
public class CompServiceImp implements CompService {

	@Autowired
	CompDao cDao;
	
	@Override
	public List<CompVO> selectAll() {
		List<CompVO> compList = cDao.selectAll();
		return compList;
	}
	@Override
	public List<CompVO> findByCName(String c_name) {
		List<CompVO> compList = cDao.findByCName(c_name);
		return compList;
	}

	
	@Override
	public CompVO findByCCode(String c_code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CompVO> findByCTel(String c_tel) {
		// TODO Auto-generated method stub
		return null;
	}

}
