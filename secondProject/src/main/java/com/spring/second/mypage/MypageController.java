package com.spring.second.mypage;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;

@Controller
public class MypageController {
	 @Autowired
	 MemberService memberService;
	 @Autowired
	 MypageService mypageService;
	 
	@Autowired
	MemberDTO memberDTO;
	 
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
		List<BoardDTO> bto = mypageService.selectMyList(id);
		mav.addObject("myList",bto);
		mav.addObject("member", dto);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "/mypage/modInfo.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity modInfo(String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		if(request.getParameter("user_pw").equals(request.getParameter("pwcheck")) ) {
		//비밀번호 일치
		System.out.println(request.getParameter("user_id"));
		System.out.println(request.getParameter("user_name"));
		System.out.println(request.getParameter("user_email"));
		System.out.println(request.getParameter("user_pw"));
		System.out.println(request.getParameter("user_address"));
		memberDTO.setUser_id(request.getParameter("user_id"));
		memberDTO.setUser_name(request.getParameter("user_name"));
		memberDTO.setUser_email(request.getParameter("user_email"));
		memberDTO.setUser_pw(request.getParameter("user_pw"));
		memberDTO.setUser_address(request.getParameter("user_address"));
		mypageService.modInfo(memberDTO);
		message = "<script>";
		message += "alert('수정이 완료되었습니다.');";
		message += "location.href='" + request.getContextPath() +"/mypage/mypageMain.do';";
		message += "</script>";
		resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		
		}else {
			//불일치
			message = "<script>";
			message += "alert('비밀번호가 일치하지 않습니다.');";
			message += "location.href='" + request.getContextPath()
				+"/mypage/modInfoForm.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}

		return resEnt;
	}
	@RequestMapping(value = "/mypage/myArticles.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView myArticles(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
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