package com.spring.second.modify.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.service.BoardService;
import com.spring.second.modify.service.ModifyService;
import com.spring.second.write.dto.ImageDTO;
@Controller
public class ModifyControllerImpl implements ModifyController{
	private static final String IMAGE_PATH = "C:\\image";
	@Autowired
	BoardService boardservice;
	@Autowired
	BoardDTO boardDTO;
	@Autowired
	ModifyService modifyservice;
	
	@Override
	@RequestMapping(value = "/modify/modPro.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modPro(@RequestParam("regNum") int regNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		Map<String, Object> proInf=new HashMap<String, Object>();
		proInf=boardservice.viewProduct(regNum);
		mav.addObject("proInf", proInf);
		return mav;
	}
	
	@RequestMapping(value="/modify/modifyProduct.do", method={RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity ModifyProduct(@RequestParam("regNum") int regNum,MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration<String> enu = multipartRequest.getParameterNames();
		List<String> fileList = upload(multipartRequest);
		List<ImageDTO> imageFileList = new ArrayList<ImageDTO>();
		
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = multipartRequest.getParameter(name).replace("\r\n", "<br>");
			System.out.println(name+" : "+value);
			articleMap.put(name, value);
		}
		System.out.println(articleMap.get("pr_img1"));
		System.out.println(articleMap.get("pr_img2"));
		System.out.println(articleMap.get("pr_img3"));
		//판매자 이름 임시 지정
		String user_id="test";
		boardDTO.setSeller_id(user_id);
		articleMap.put("seller_id", user_id);
		articleMap.put("regNum", regNum);
		if(fileList != null && fileList.size() != 0) {
			for(String fileName : fileList) {
				ImageDTO image = new ImageDTO();
				image.setImageFileName(fileName);
				imageFileList.add(image);
				if(articleMap.get("pr_img1")==null) {
					articleMap.put("pr_img1", fileName );
				}
				else if(articleMap.get("pr_img2")==null) {
					articleMap.put("pr_img2", fileName );
				}
				else if(articleMap.get("pr_img3")==null) {
					articleMap.put("pr_img3", fileName );
				}
			}
			articleMap.put("imageFileList", imageFileList);
		}
		//------
		
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		//-----
		if(articleMap.get("pr_img1")!=null) {
			try {
				modifyservice.modifyproduct(articleMap);
				
				if(imageFileList != null && imageFileList.size() != 0) {
					for(ImageDTO imageDTO : imageFileList) {
						File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
						File destDir = new File(IMAGE_PATH + "\\" + regNum);
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					}
				}
				message = "<script>";
				message += "alert('새글을 추가했습니다.');";
				message += "location.href='" + multipartRequest.getContextPath() +"/product/viewProduct.do?regNum="+regNum+"';";
				message += "</script>";
				resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
			} catch(Exception e) {
				if(imageFileList != null && imageFileList.size() != 0) {
					for(ImageDTO imageDTO : imageFileList) {
						File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
						srcFile.delete();
					}
				}
				e.printStackTrace();
			}
		}else {
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/modify/modPro.do?regNum="+regNum+"';";
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

