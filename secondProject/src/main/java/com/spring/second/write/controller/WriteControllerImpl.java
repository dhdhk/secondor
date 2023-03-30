package com.spring.second.write.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class WriteControllerImpl implements WriteController{

	@Override
	@RequestMapping("/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "write";
	}

}
