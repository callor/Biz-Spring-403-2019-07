package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompVO {
	private String c_code;//	varchar2(5 byte)
	private String c_name;//	nvarchar2(50 char)
	private String c_ceo;//		nvarchar2(50 char)
	private String c_tel;//		varchar2(20 byte)
	private String c_addr;//	nvarchar2(255 char)
}
