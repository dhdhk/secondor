package com.spring.second.mypage.controller;

import java.io.File;
import java.util.Enumeration;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.controller.MemberControllerImpl;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;
import com.spring.second.mypage.dao.MypageDAOImpl;
import com.spring.second.mypage.dto.MypageHandler;
import com.spring.second.mypage.dto.MyproductlistPage;
import com.spring.second.mypage.service.MypageService;


@Controller
public class MypageControllerImpl implements MypageController{
	private static final String IMAGE_PATH = "C:\\image";
	 @Autowired
	 MemberService memberService;
	 
	 @Autowired
	 MypageService mypageService;
	 
	 @Autowired
	 MemberDTO memberDTO;
	 
	 @Autowired
	 MemberControllerImpl mc;
	 
	@RequestMapping(value = "/mypage/mypageMain.do" , method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mypageMain(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String user_id= member.getUser_id();
		MemberDTO dto = memberService.selectMember(user_id);
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", dto);
		return mav;
	}
	
	@RequestMapping(value="/mypage/*Form.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView form(@RequestParam(value="result", required = false) String result,
			@RequestParam(value="action", required = false) String action,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String id= member.getUser_id();
		ModelAndView mav = new ModelAndView(viewName);
		MemberDTO dto = memberService.selectMember(id);
//		List<BoardDTO> bto = mypageService.selectMyList(id);
//		mav.addObject("myList",bto);
		mav.addObject("member", dto);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "/mypage/modInfo.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity modInfo(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> memberMap = new HashMap<String, Object>();
		Enumeration<String> enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = multipartRequest.getParameter(name);
			System.out.println(name+" : "+value);
			memberMap.put(name, value);
		}
		
		
		String filename=null;
		try{
			filename = mc.upload(multipartRequest);
			System.out.println(filename);
			if(filename.length()==0) {
				filename=null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		HttpSession session = multipartRequest.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String user_id= member.getUser_id();
		
		String old = mypageService.getprofilename(member);
		member.setProfileimg(old);
		String user_pw=multipartRequest.getParameter("user_pw");
		String pwcheck=multipartRequest.getParameter("pwcheck");
		System.out.println(user_pw);
		System.out.println(pwcheck);
		if(!user_pw.equals(pwcheck)) {
			//비밀번호 랑 비밀번호 확인 일치하지않을때
			message = "<script>";
			message += "alert('비밀번호가 일치하지않습니다.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/mypage/modInfoForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			return resEnt;
		}
		System.out.println(member.getProfileimg());
		try {
		
			if(filename==null && member.getProfileimg()==null) {
				//프로필 사진 없다가 추가안할때
				memberMap.put("porfileimg", null);
				mypageService.modInfoNoimg(memberMap);
			}else if(filename==null&& member.getProfileimg()!=null){
				//프사 있다가 삭제했을떄
				memberMap.put("porfileimg", null);
				mypageService.modInfoNoimg(memberMap);
				//원래있던 사진파일 삭제
				File oldfile = new File(IMAGE_PATH + "\\member\\"+user_id+ "\\"+ member.getProfileimg());
				oldfile.delete();
			}else if(filename!=null && member.getProfileimg()==null){
				//프사없다가 추가할때
				memberMap.put("profileimg", filename);
				File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + filename);
				File destDir = new File(IMAGE_PATH + "\\member\\" + user_id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				mypageService.modInfo(memberMap);
			}else {
				//프사 있다가 변경할때
				//원래있던 파일 삭제
				File oldfile = new File(IMAGE_PATH + "\\member\\"+user_id+ "\\"+ member.getProfileimg());
				oldfile.delete();
				memberMap.put("profileimg", filename);
				File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + filename);
				File destDir = new File(IMAGE_PATH + "\\member\\" + user_id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				mypageService.modInfo(memberMap);
			}
			
			message = "<script>";
			message += "alert('내 정보 수정이 완료되었습니다.');";
			message += "location.href='" + multipartRequest.getContextPath() +"/mypage/mypageMain.do';";
			message += "</script>";
			resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		
		}catch (Exception e) {
			if(filename!=null) {
					File srcFile = new File(IMAGE_PATH + "\\" + "temp" + "\\" + filename);
					srcFile.delete();
			}
			
			message = "<script>";
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요.');";
			message += "location.href='" + multipartRequest.getContextPath()
				+"/mypage/modInfoForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		
			
		return resEnt;
	}
	
//내 상품 리스트 
	@RequestMapping(value = "/mypage/myArticles.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String myArticles(MyproductlistPage mp,Model m, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//member id값을 seller_id 에 넣어줘야함
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String id= member.getUser_id();
		mp.setSeller_id(id);
		
		int totalCnt = mypageService.getProductListCount(mp);
		m.addAttribute("my_totalCnt", totalCnt);
		System.out.println("totalCnt:"+totalCnt);
		System.out.println(mp);
		
		mp.setStart();
		mp.setEnd();
		
		System.out.println("my_page : " + mp.getPage());
		System.out.println("my_start : " + mp.getStart());
		System.out.println("my_end : " + mp.getEnd());
		
		MypageHandler mypageHandler = new MypageHandler(totalCnt, mp);
		
		List<BoardDTO> myList = mypageService.getselectMyList(mp);
		m.addAttribute("myList", myList);
		m.addAttribute("mh", mypageHandler);
		
		return "/mypage/myArticles";
	}
	@RequestMapping(value = "/mypage/myChatlist.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView myChatlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	@RequestMapping(value = "/mypage/dropOut.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView dropOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
}