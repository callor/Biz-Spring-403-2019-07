package com.biz.memo.dao;

import java.util.List;

import com.biz.memo.model.MemoVO;

public interface MemoDao {

	public List<MemoVO> selectAll();
	
}
