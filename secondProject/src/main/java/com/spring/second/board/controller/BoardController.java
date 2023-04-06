package com.spring.second.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.SearchCondition;

public interface BoardController {
//	public String listArticles(@RequestParam(defaultValue ="1") Integer page , Model m,
//			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public String listArticles(SearchCondition sc , Model m,
	HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView listArticlesByCategory (@RequestParam("category_name") String category_name,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
//	public ModelAndView viewProduct(@RequestParam("regNum") int regNum, 
//			HttpServletRequest request, HttpServletResponse response) throws Exception;
}