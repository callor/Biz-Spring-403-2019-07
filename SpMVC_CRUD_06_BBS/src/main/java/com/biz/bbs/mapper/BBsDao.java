package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.biz.bbs.model.BBsVO;

public interface BBsDao {

	@Select(" SELECT * FROM tbl_bbs ")
	public List<BBsVO> selectAll();

	
	@InsertProvider(type=BBsSQL.class,method="bbs_insert_sql")
	@SelectKey(keyProperty = "bbs_seq",
				resultType = "long",
				before = true)
	public int insert(BBsVO bbsVO);

	@Select(" SELECT * FROM tbl_bbs WHERE bbs_seq = #{bbs_seq} ")
	public BBsVO findBySeq(long bbs_seq);
	
}
