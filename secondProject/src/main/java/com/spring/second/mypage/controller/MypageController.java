package com.spring.second.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.mypage.dto.MyproductlistPage;

public interface MypageController {

	
	public ModelAndView mypageMain(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	
	public ModelAndView form(@RequestParam(value="result", required = false) String result,@RequestParam(value="action", required = false) String action,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity modInfo(String id,HttpServletRequest request, HttpServletResponse response) throws Exception;

	public String myArticles(MyproductlistPage mp,Model m, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView myChatlist(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView dropOut(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
