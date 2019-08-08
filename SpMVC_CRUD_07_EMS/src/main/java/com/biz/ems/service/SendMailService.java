package com.biz.ems.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.ems.model.EmailVO;

@Service	
public class SendMailService {
	
	@Autowired
	JavaMailSender xMail;

	@Autowired
	ServletContext context;
	
	private final String uploadFolder = "c:/bizwork/upload/";
	public void sendMail(EmailVO mailVO) {
		
		String from_email = mailVO.getEms_from_email();
		String to_email = mailVO.getEms_to_email();
		String subject = mailVO.getEms_subject();
		String content = mailVO.getEms_content();
		String file1 = mailVO.getEms_file1();
		
		// Email에 사용되는 문서구조 생성 : MimeMessage 라고한다
		MimeMessage message = xMail.createMimeMessage();
		
		// 메일을 보낼때 사용할 보조도구 선언
		MimeMessageHelper mHelper;
		
		try {
			mHelper = new MimeMessageHelper(message,true,"UTF-8");
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			mHelper.setText(content);
			
			FileSystemResource fr
			= new FileSystemResource(new File(uploadFolder,file1));
			
			mHelper.addAttachment(file1, fr);
			xMail.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
}
