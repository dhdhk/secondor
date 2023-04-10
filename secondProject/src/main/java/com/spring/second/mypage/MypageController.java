package com.spring.second.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;




@Controller
public class MypageController {
	 @Autowired
	 MemberService ms;
	 
//	@Autowired
//	MemberDTO memberDTO;
	 
	@RequestMapping(value = "/mypage/mypageMain.do" )
	public ModelAndView mypageMain(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
//		HttpSession session = request.getSession();
//		MemberDTO member = (MemberDTO)session.getAttribute("member");
		//임시아이디 지정
		id = "hong";
//		String name= member.getUser_name();
		
		MemberDTO dto = ms.selectMember(id);
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", dto);
		return mav;
	}
	
	@RequestMapping(value="/mypage/*Form.do")
	public ModelAndView form(@RequestParam(value="result", required = false) String result,
			@RequestParam(value="action", required = false) String action,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		ModelAndView mav = new ModelAndView(viewName);
		//임시아이디지정
		String id = "hong";
		MemberDTO dto = ms.selectMember(id);
		mav.addObject("member", dto);
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "/mypage/modInfo.do")
	public ModelAndView modInfo(String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	@RequestMapping(value = "/mypage/myArticles.do")
	public ModelAndView myArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	@RequestMapping(value = "/mypage/myChatlist.do")
	public ModelAndView myChatlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	@RequestMapping(value = "/mypage/dropOut.do")
	public ModelAndView dropOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
}
