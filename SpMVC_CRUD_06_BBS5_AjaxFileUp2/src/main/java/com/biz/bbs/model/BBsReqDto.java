package com.biz.bbs.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public class BBsReqDto {
	
	/*
	 * validation에서 사용할수 있는 유효성 검사항목들
	 * @NotBlank : 빈칸이어서는 안된다.
	 * @NotNull : null값이어서는 안된다.
	 * @Null : 반드시 null이어야 한다.
	 * @Size(min=x, max=y) : 개수가 x개 부터 y개까지만 인정
	 * @Max(x) : 숫자가 x 이상이면 안된다.
	 * @Min(x) : 숫자가 y 이하이면 안된다.
	 * 
	 * @DecimalMax(x) : 10진수 x 이상이면 안된다.
	 * @DecimalMin(x) : 10진수 x 이하이면 안된다.
	 * 
	 * @Email : 이메일형식이 아니면 안된다.
	 * 
	 */
	
    private long bbs_seq;//	NUMBER	PRIMARY KEY,
    private long bbs_main_seq;//	NUMBER,	
    private int bbs_layer;//	NUMBER,	
        
    private String bbs_date;//	VARCHAR2(10),	
    private String bbs_time;//	VARCHAR2(20),
    
    @NotBlank(message = "사용자 이름을 입력해야 합니다.")
    @Email(message = " * 사용자이름은 이메일 형식이어야 합니다")
    private String bbs_auth;//	nVARCHAR2(50),	
    private String bbs_title;//	nVARCHAR2(255),	
    
    
    private String bbs_content;//	nVARCHAR2(1000)	
    
    private List<String> bbs_files ;
    private List<String> bbs_origin_files ;
    
}
