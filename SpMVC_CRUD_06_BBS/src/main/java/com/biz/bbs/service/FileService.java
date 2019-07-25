package com.biz.bbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.model.FileVO;

@Service
public class FileService {

	/*
	 * 파일들의 이름을 UUID 이름으로 변경하고
	 * 변경된 파일들의 이름을 FileVO에 담아서
	 * 리턴 하는 method 
	 */
	public List<FileVO> getFileNames(List<MultipartFile> files) {
		
		List<FileVO> fileList = new ArrayList<FileVO>();
		for(MultipartFile file : files) {
			
			String originName = file.getOriginalFilename();
			String uuString = UUID.randomUUID().toString();
			String saveName = uuString + "_" + originName;
			
			fileList.add(
					FileVO.builder()
						.file_origin_name(originName)
						.file_name(saveName).build()
			);
		}
		return fileList;
	}
	
}
