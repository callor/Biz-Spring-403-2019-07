package com.biz.iolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.mapper.IolistDao;
import com.biz.iolist.model.IolistDto;
import com.biz.iolist.model.IolistVO;

@Service
public class IolistServiceImp implements IolistService {

	@Autowired
	IolistDao ioDao;
	
	@Override
	public List<IolistVO> selectAll() {
		List<IolistVO> iolist = ioDao.selectAll();
		return iolist;
	}

	@Override
	public IolistVO findBySeq(long io_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(IolistVO iolistVO) {
		int ret = ioDao.insert(iolistVO);
		return ret ;
	}

	@Override
	public int update(IolistVO iolistVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long io_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IolistDto> selectJoin() {
		List<IolistDto> iolist = ioDao.selectJoin();
		return iolist;
	}

}
