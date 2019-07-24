package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.ProductDao;
import com.biz.iolist.model.ProductVO;

@Service
public class ProductService {

	@Autowired
	ProductDao pDao;
	
	public List<ProductVO> selectAll(){
		List<ProductVO> proList = pDao.selectAll();
		return proList;
	}

	public List<ProductVO> findByName(String p_name) {
		List<ProductVO> proList = pDao.findByName(p_name);
		return proList;
	}
	
}
