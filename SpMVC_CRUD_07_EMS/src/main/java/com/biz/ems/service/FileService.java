package com.biz.ems.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	
	private final String uploadFolder = "c:/bizwork/upload/";
	
	public String fileUp(MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		File saveFile = new File(uploadFolder,fileName);
		
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
}
