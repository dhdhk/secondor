package com.spring.second.write.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface WriteController {

	public ModelAndView write(HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
