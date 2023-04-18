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
import javax.servlet.http.HttpSession;

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
import com.spring.second.member.dto.MemberDTO;
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
		System.out.println("1111");
		List<ImageDTO> imageFileList = new ArrayList<ImageDTO>();
		
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = multipartRequest.getParameter(name).replace("\r\n", "<br>");
			if(value.length()==0) {
				//사진이없을땐 null값을 넣도록함
				value=null;
			}
			System.out.println(name+" : "+value);
			articleMap.put(name, value);
		}
		//boardDTO에 regNum값을 넣어서 이미지파일 이름들을 가져옴
	    boardDTO=modifyservice.getfilename(regNum);
	    String old1=boardDTO.getPr_img1();
	    String old2=boardDTO.getPr_img2();
	    String old3=boardDTO.getPr_img3();
		//Map에 파일이름 받아와서 넣기
		for(String fileName : fileList) {
			ImageDTO image = new ImageDTO();
			image.setImageFileName(fileName);
			imageFileList.add(image);
			//사진 수정안했을때 old파일이 존재 > old파일을 pr_img값으로
			if((articleMap.get("pr_img1")==null && articleMap.get("old1")!=null)&&fileName.length()==0) {
			articleMap.put("pr_img1", old1 );
			}
			//수정했을때 
			else if(articleMap.get("pr_img1")==null){
				articleMap.put("pr_img1", fileName );
			}else if((articleMap.get("pr_img2")==null && articleMap.get("old2")!=null)&&fileName.length()==0) {
				articleMap.put("pr_img2", old2 );
			}
			else if(articleMap.get("pr_img2")==null) {
				articleMap.put("pr_img2", fileName );
			}else if((articleMap.get("pr_img3")==null && articleMap.get("old3")!=null)&&fileName.length()==0) {
				articleMap.put("pr_img3", old3 );
			}
			else if(articleMap.get("pr_img3")==null) {
				articleMap.put("pr_img3", fileName );
			}
		}
		articleMap.put("imageFileList", imageFileList);
		System.out.println("pr_img1 : "+articleMap.get("pr_img1"));
		System.out.println("pr_img2 : "+articleMap.get("pr_img2"));
		System.out.println("pr_img3 : "+articleMap.get("pr_img3"));
		System.out.println("old1 : " +articleMap.get("old1"));
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		//첫번째사진없으면 경고창뜨면서 돌아오게함
		if(articleMap.get("old1")==null&&articleMap.get("pr_img1")==null) {
			message = "<script>";
			message += "alert('첫 번째 사진을 반드시 첨부해주세요.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/modify/modPro.do?regNum="+regNum+"';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			return resEnt;
		}
		//이 밑으로 첫이미지없으면 or 이미지 리스트가없다는 조건 전부삭제했습니다.
		//판매자 이름 지정
		HttpSession session = multipartRequest.getSession();
	    MemberDTO memberDTO=(MemberDTO) session.getAttribute("member");
	    String user_id= memberDTO.getUser_id();
	    
	    
		articleMap.put("seller_id", user_id);
		articleMap.put("regNum", regNum);
		
		
		
		//사진을 수정했을경우 (이전파일이름과 현재파일이름이 다를때) 이전사진을 삭제
		
		String pr_img1 = (String) articleMap.get("pr_img1");
		String pr_img2 = (String) articleMap.get("pr_img2");
		String pr_img3 = (String) articleMap.get("pr_img3");
		System.out.println(pr_img1);
		System.out.println(pr_img2);
		System.out.println(pr_img3);
		if((articleMap.get("pr_img1")!=old1&&pr_img1.length()!=0 )|| articleMap.get("old1")==null) {
			File oldfile = new File(IMAGE_PATH + "\\" + regNum+ "\\"+ old1);
			oldfile.delete();
		}
		if((articleMap.get("pr_img2")!=old2&&pr_img2.length()!=0)|| articleMap.get("old2")==null) {
			File oldfile = new File(IMAGE_PATH + "\\" + regNum+ "\\"+ old2);
			oldfile.delete();
		}
		if((articleMap.get("pr_img3")!=old3&&pr_img3.length()!=0)|| articleMap.get("old3")==null) {
			File oldfile = new File(IMAGE_PATH + "\\" + regNum+ "\\"+ old3);
			oldfile.delete();
		}
			
			
			try {
				
					for(ImageDTO imageDTO : imageFileList) {
						try {
							if(imageDTO.getImageFileName().length()!=0) {
								File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
								File destDir = new File(IMAGE_PATH + "\\" + regNum);
								FileUtils.moveFileToDirectory(srcFile, destDir, true);}
						} catch (Exception e) {
							// TODO: handle exception
							// 같은 이름 사진 두장이상 첨부했을때 오류나니까 거절하기
							message = "<script>";
							message += "alert('같은 이름의 사진을 첨부할 수 없습니다.');";
							message += "location.href='" + multipartRequest.getContextPath()
								+"/modify/modPro.do?regNum="+regNum+"';";
							message += "</script>";
							resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
							return resEnt;
						}
						
					}
					modifyservice.modifyproduct(articleMap);
				message = "<script>";
				message += "alert('수정을 완료했습니다.');";
				message += "location.href='" + multipartRequest.getContextPath() +"/product/viewProduct.do?regNum="+regNum+"';";
				message += "</script>";
				resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
			} catch(Exception e) {
					for(ImageDTO imageDTO : imageFileList) {
						if(imageDTO.getImageFileName().length()!=0) {
						File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + imageDTO.getImageFileName());
						srcFile.delete();}
					}
				e.printStackTrace();
			}
		
		return resEnt;
	}
	
	private List<String> upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();
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
				mFile.transferTo(new File(IMAGE_PATH+"\\temp\\"+originalFileName));}
			
		}
		return fileList;
	}
}

