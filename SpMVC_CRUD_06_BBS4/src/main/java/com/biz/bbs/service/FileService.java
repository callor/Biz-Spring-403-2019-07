package com.biz.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.mapper.FileDao;
import com.biz.bbs.model.BBsVO;
import com.biz.bbs.model.FileVO;

@Service
public class FileService {
	
	@Autowired
	FileDao fDao;
	
	private String upLoadFolder = "c:/bizwork/upload/";

	public void uploadFileList(BBsVO bbsVO) {

		// 1. VO에서 파일 리스트를 추출
		List<MultipartFile> files = bbsVO.getBbs_files();
		
		// 2. VO에서 seq 값 추출
		long bbs_seq = bbsVO.getBbs_seq();
		
		// 3. (업로드된)파일의 개수만큼 반복문 수행
		for(MultipartFile file : files) {
			
			// 4. 파일정보에서 원래 파일이름 추출 
			String originName = file.getOriginalFilename();
			
			// 5. 파일이름에 UUID를 추가하여 
			String uuString = UUID.randomUUID().toString();
			
			// 6. UUID와 원래파일이름을 연결해서
			// 7. 저장하는 파일 이름으로 생성
			String saveName = uuString + "_" + originName;

			// 업로드될 폴더 + UUID 파일이름 묶어서 File 객체로 생성
			File uploadFile
				= new File(upLoadFolder, saveName); 
			
			try {
			
				// 서버의 폴더에 저장하기
				file.transferTo(uploadFile);
				
				// 한개의 파일정보를 insert 수행
				fDao.insert(FileVO.builder()
						.file_bbs_seq(bbs_seq) // tbl_bbs와 tbl_bbs_file 을 연결하는 key
						.file_name(saveName) // view에서 확인할 파일명
						.file_origin_name(originName).build()); // 원래 원본 파일이름

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean file_delete(long file_seq) {

		//1. 파일 정보 추출
		FileVO fileVO = fDao.findBySeq(file_seq);
		
		//2. 파일의 물리적 경로 생성
		File delFile = new File(upLoadFolder, fileVO.getFile_name());
		
		// 3. 파일이 있는지 확인 한 후
		if(delFile.exists()) {
			
			// 4. 파일 삭제
			delFile.delete();
			
			// 5. DB 정보 삭제
			fDao.delete(file_seq);
		
			return true;
		}
		
		return false;
		
		
	}
	

}
