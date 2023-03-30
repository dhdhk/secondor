package com.spring.second.write.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WriteController {

	public String write(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
