package com.spring.second.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.chat.dto.ChatRoomDTO;
import com.spring.second.chat.service.ChatService;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;

@Controller
public class ChatController {
	@Autowired
	private ChatService chatservice;
	
	@RequestMapping(value="/chat/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("user_id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ChatController로 넘어온 id : "+ id);
		
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("id", id);
		
		return mav;
	}
	
	@RequestMapping(value = "/chatForm.do", method = { RequestMethod.GET })
	public String chat (HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		return "chatForm";
	}
	
}