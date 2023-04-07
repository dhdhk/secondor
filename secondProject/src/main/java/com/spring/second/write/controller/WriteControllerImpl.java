package com.spring.second.write.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.write.dto.ImageDTO;
import com.spring.second.write.file.FileUploadController;
import com.spring.second.write.service.WriteService;

@Controller
public class WriteControllerImpl implements WriteController{
	private static final String IMAGE_PATH = "C:\\image";
	@Autowired
	WriteService writeService;
	@Autowired
	BoardDTO boardDTO;
	
	
	@Override
	@RequestMapping(value = "/write/writeForm.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/board/viewArticle.do")
	public ModelAndView viewArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	@RequestMapping(value="/write/addNewArticle.do", method=RequestMethod.POST)
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration<String> enu = multipartRequest.getParameterNames();
		

		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = multipartRequest.getParameter(name).replace("\r\n", "<br>");
			System.out.println(name+" : "+value);
			articleMap.put(name, value);
		}
		List<String> fileList = upload(multipartRequest);
		List<ImageDTO> imageFileList = new ArrayList<ImageDTO>();
		//판매자 이름 임시 지정
		String user_id="test";
		boardDTO.setSeller_id(user_id);
		articleMap.put("seller_id", user_id);
		int regNum=writeService.addNewRegNum();
		articleMap.put("regNum", regNum);
		if(fileList != null && fileList.size() != 0) {
			int i=1;
			for(String fileName : fileList) {
				ImageDTO image = new ImageDTO();
				image.setImageFileName(fileName);
				imageFileList.add(image);
				articleMap.put("pr_img"+i, fileName );
				i++;
			}
			articleMap.put("imageFileList", imageFileList);
		}
		//------
		
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		//-----
		if(imageFileList != null && imageFileList.size() != 0) {
		try {
			writeService.addNewArticle(articleMap);
			
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO : imageFileList) {
					File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
					File destDir = new File(IMAGE_PATH + "\\" + regNum);
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
			}
			message = "<script>";
			message += "alert('새글을 추가했습니다.');";
			message += "location.href='" + multipartRequest.getContextPath() +"/board/viewArticle.do';";
			message += "</script>";
			resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		} catch(Exception e) {
			if(imageFileList != null && imageFileList.size() != 0) {
				for(ImageDTO imageDTO : imageFileList) {
					File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
					srcFile.delete();
				}
			}
			
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/write/writeForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}}else {
			message = "<script>";
			message += "alert('사진은 반드시 1장 이상 첨부 되어야 합니다.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/write/writeForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			
		}
		return resEnt;
	}
	
	private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();
		Map<String, String> articleMap = new HashMap<String, String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			File file = new File(IMAGE_PATH+"\\"+fileName);
			if(mFile.getSize()!=0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(IMAGE_PATH+"\\temp\\"+originalFileName));
			}
		}
		return fileList;
	}
}
