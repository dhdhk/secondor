package com.spring.second.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.service.BoardService;
import com.spring.second.chat.dto.ChatDTO;
import com.spring.second.chat.service.ChatService;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;

@Controller
public class ChatController {
	@Autowired
	private ChatService chatservice;

	@RequestMapping(value="/chat/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

	@RequestMapping(value = "/chat/chatForm.do", method = { RequestMethod.GET })
	@ResponseBody
	public ModelAndView chat(@RequestParam("buyer_id") String id, @ModelAttribute("board") BoardDTO board,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		/* 
		 * 1:1 ä���� buyer�� seller�� id �ϳ�
		 * chatroom�� id�� �����´�
		 * id�� �ִٸ� ���
		 * ���ٸ� ��ȭ�� ����
		 */

		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		Map<String, Object> ids = new HashMap<String, Object>();
		ids.put("id", id);
		ids.put("seller_id", board.getSeller_id());
		ids.put("pr_title", board.getPr_title());
		ids.put("pr_id", board.getRegNum());
//		System.out.println("id : " + id);
//		System.out.println("seller_id : " + board.getSeller_id());
//		System.out.println("pr_title : " + board.getPr_title());
//		System.out.println("pr_id : " + board.getRegNum());

		ChatDTO chatDTO = new ChatDTO();
		chatDTO = chatservice.searchChatRoom(ids);

		mav.addObject("chatDTO", chatDTO);

		return mav;
	}

	@RequestMapping(value="/chat/chatList.do")
	public ModelAndView chatList(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		// TODO Auto-generated method stub
		System.out.println("chatList �۾�");
		String viewName = (String)request.getAttribute("viewName");
		List<ChatDTO> chatList = chatservice.listchats();

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chatList", chatList);

		return mav;
	}
}