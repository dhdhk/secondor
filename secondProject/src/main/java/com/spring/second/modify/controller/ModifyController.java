package com.spring.second.modify.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ModifyController {
	public ModelAndView modPro(@RequestParam("regNum") int regNum, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
