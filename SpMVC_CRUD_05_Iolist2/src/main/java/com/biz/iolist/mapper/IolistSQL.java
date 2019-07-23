package com.biz.iolist.mapper;

import org.apache.ibatis.jdbc.SQL;

public class IolistSQL {

	public String iolist_insert_sql() {
		
		SQL sql = new SQL();
		sql.INSERT_INTO("tbl_iolist");
		sql.INTO_COLUMNS("io_seq").INTO_VALUES("SEQ_IOLIST.NEXTVAL");
		sql.INTO_COLUMNS("io_date").INTO_VALUES("#{io_date,jdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_pcode").INTO_VALUES("#{io_pcode,jdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_ccode").INTO_VALUES("#{io_ccode,jdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_inout").INTO_VALUES("#{io_inout,jdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_qty").INTO_VALUES("#{io_qty,jdbcType=INTEGER}");
		sql.INTO_COLUMNS("io_price").INTO_VALUES("#{io_price,jdbcType=INTEGER}");
		sql.INTO_COLUMNS("io_total").INTO_VALUES("#{io_total,jdbcType=INTEGER}");
		
		return sql.toString();
	}
	
	public String iolist_update_sql() {
		// build pattern 방식의 코드
		SQL sql = new SQL()
			.UPDATE("tbl_iolist")
			.SET("io_seq = #{io_seq}")
			.SET("io_date = #{io_date}")
			.SET("io_pcode = #{io_pcode}")
			.SET("io_ccode = #{io_ccode}")
			.SET("io_inout = #{io_inout}")
			.SET("io_qty = #{io_qty}")
			.SET("io_price = #{io_price}")
			.SET("io_total = #{io_total}");
		
		return sql.toString();
	}
	
	public String iolist_select_join() {
		
		SQL sql = new SQL()
			    .SELECT("io_seq")
			    .SELECT("io_date")
			    .SELECT("io_inout")
			    .SELECT("io_ccode")
			    .SELECT("c_name AS io_cname")
			    .SELECT("io_pcode")
			    .SELECT("p_name AS io_pname")
			    .SELECT("io_qty")
			    .SELECT("io_price")
			    .SELECT("DECODE(io_inout,'1',io_total,0) AS io_itotal")
			    .SELECT("DECODE(io_inout,'2',io_total,0) AS io_ototal")
				.FROM("tbl_iolist")
				.LEFT_OUTER_JOIN("tbl_comp ON io_ccode = c_code ")
				.LEFT_OUTER_JOIN("tbl_product ON io_pcode = p_code ");
		
		return sql.toString();
		
	}
	
	
	
}
