package com.spring.second.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AdminController {
	public ModelAndView prdel1(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView deleteMember(String user_id, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}