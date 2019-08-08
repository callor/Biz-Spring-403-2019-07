package com.biz.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailVO {
    private long ems_seq;
    
    @NotBlank(message = "* 받는 Email은 필수항목입니다")
    @Email(message = "* Email 형식이 잘못되었습니다")
    private String ems_to_email;

    @NotBlank(message = "* 보내는 Email은 필수항목입니다")
    @Email(message = "* Email 형식이 잘못되었습니다")
    private String ems_from_email;

    @NotBlank(message = "* 보내는 사람 이름은 필수항목입니다")
    private String ems_to_name;
    private String ems_from_name;		
    private String ems_send_date;
    private String ems_send_time;
    
    @NotBlank(message = "* 제목은 필수항목입니다")
    private String ems_subject;
    
    @NotBlank(message = "* 내용 필수항목입니다")
    private String ems_content;
    private String ems_file1;		
    private String ems_file2;	
}
