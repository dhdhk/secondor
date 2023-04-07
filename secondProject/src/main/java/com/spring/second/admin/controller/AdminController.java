package com.spring.second.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminController {
	public ModelAndView prdel1(HttpServletRequest request, HttpServletResponse response) throws Exception;
}