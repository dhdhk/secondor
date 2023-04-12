package com.spring.second.member.controller;

import java.io.IOException;

import javax.servlet.http.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.second.member.dto.MemberDTO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addMember(@ModelAttribute("member") MemberDTO member, MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(@RequestParam("user_id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception;	
	public ModelAndView modMemberForm(@RequestParam("user_id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modMember(@ModelAttribute("member") MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("member") MemberDTO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findId(RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws IOException;
	public ModelAndView findPw(RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	public ModelAndView findIdForm(@ModelAttribute("member") HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findIdShow(HttpServletRequest request, HttpServletResponse response) throws Exception;
}