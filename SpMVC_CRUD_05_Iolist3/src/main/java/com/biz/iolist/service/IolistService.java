package com.biz.iolist.service;

import java.util.List;

import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;

public interface IolistService {

	public List<IolistVO> selectAll();
	public List<IolistDto> selectJoin();
	
	public IolistVO findBySeq(long io_seq);
	public int insert(IolistVO iolistVO);
	public int update(IolistVO iolistVO);
	public int delete(long io_seq);
	
	
}
