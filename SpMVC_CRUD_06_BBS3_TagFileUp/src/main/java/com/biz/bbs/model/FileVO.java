package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

    private long file_seq;//	NUMBER	PRIMARY KEY,
    private long file_bbs_seq;//	NUMBER,	
    private String file_origin_name;//	nVARCHAR2(1000),	
    private String file_name;//	nVARCHAR2(1000)
	
}
