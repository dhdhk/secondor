package com.spring.second.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.admin.service.AdminService;
import com.spring.second.board.dto.BoardDTO;

@Controller
public class AdminControllerImpl implements AdminController{
	@Autowired
	AdminService adminService;
	
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
}