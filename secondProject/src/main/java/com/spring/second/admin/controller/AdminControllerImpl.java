package com.spring.second.admin.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.second.admin.service.AdminService;
import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.controller.MemberControllerImpl;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;

@Controller
@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController{
	@Autowired
	AdminService adminService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberDTO member;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class); 
	
	@Override
	@RequestMapping(value="/admin/prdel.do")
	public ModelAndView prdel1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		List<BoardDTO> productList = adminService.ListProduct("");
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productList", productList);
		int totalNum=productList.size();
		return mav;
	}
	
	@RequestMapping(value="/admin/deletePr.do", method=RequestMethod.POST)
	public ModelAndView deletePr(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String deleteselection[] = request.getParameterValues("deleteselection");
		if(deleteselection==null) {
			System.out.println("선택된 내용이 없습니다");
		}else {
			for(int i=0;i<deleteselection.length;i++) {
				System.out.println(deleteselection[i]+"\n");
			}
			adminService.deletepr(deleteselection);
		}
		
		List<BoardDTO> productList = adminService.ListProduct("");
		ModelAndView mav= new ModelAndView("/admin/prdel");
		mav.addObject("productList", productList);
		return mav;
	}
	
	@RequestMapping(value="/admin/delsearch.do", method=RequestMethod.POST)
	public ModelAndView delsearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search=request.getParameter("search");
		List<BoardDTO> productList = adminService.ListProduct(search);
		ModelAndView mav = new ModelAndView("/admin/prdel");
		mav.addObject("productList", productList);
		
		return mav;	
	}
	
	//회원리스트 불러오기
	@Override
	@RequestMapping(value="/admin/listMembers.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String viewName = (String) request.getAttribute("viewName");
		List<MemberDTO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);

		logger.info("viewName : " + viewName);
		logger.debug("viewName : " + viewName);

		mav.addObject("membersList", membersList);
		return mav;
	}
	
	//회원 삭제 
	@Override
	@RequestMapping(value="/admin/removeMember.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity removeMember(RedirectAttributes rAttr,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String id= member.getUser_id();
		memberService.removeMember(id);
		
		System.out.println("admin_id: "+id);
		session.removeAttribute("member");
		String message;
		ResponseEntity<String> resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		message = "<script>";
		message += "alert('회원 삭제가 완료되었습니다.');";
		message += "location.href='" + request.getContextPath() +"/main.do';";
		message += "</script>";
		resEnt = new ResponseEntity<String>(message, responseHeaders, HttpStatus.OK);
		return resEnt;
	}
}