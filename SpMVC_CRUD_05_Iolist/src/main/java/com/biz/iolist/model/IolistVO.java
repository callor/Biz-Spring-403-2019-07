package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

// @Data
public class IolistVO {
	private long io_seq;//	NUMBER
	private String io_date;//	VARCHAR2(10)
	private String io_pcode;//	nVARCHAR2(5)
	private String io_ccode;//	nVARCHAR2(5)
	private String io_inout;//	VARCHAR2(1)
	private int io_qty;//	NUMBER
	private int io_price;//	NUMBER
	private int io_total;//	NUMBER

}
