package com.spring.second.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dao.BoardDAO;
import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.service.BoardService;
import com.spring.second.chat.dto.ChatDTO;
import com.spring.second.chat.service.ChatService;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.member.service.MemberService;

@RestController
public class ChatController {
	@Autowired
	private ChatService chatservice;
	@Autowired
	SqlSession sqlSession;

	@RequestMapping(value="/chat/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

	@RequestMapping(value = "/chat/chatForm.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView chat(@RequestParam("buyer_id") String id, @RequestParam("regNum") int regNum,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		/* 
		 * 1:1 채팅은 buyer과 seller간 id 하나
		 * chatroom의 id를 가져온다
		 * id가 있다면 출력
		 * 없다면 대화방 생성
		 */
		System.out.println(id);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		Map<String, Object> ids = new HashMap<String, Object>();
		ids.put("id", id);
		// regNum만 받아와서
		BoardDTO board = sqlSession.selectOne("mapper.board.selectProduct", regNum);
//		System.out.println("regNum : " + board.getRegNum());
		ids.put("pr_id", board.getRegNum());
//		ids.put("seller_id", board.getSeller_id());
//		ids.put("pr_title", board.getPr_title());
//		ids.put("pr_id", board.getRegNum());
//		ids.put("pr_img1", board.getPr_img1());
		System.out.println("pr_img1 : " + board.getPr_img1());

		ChatDTO chatDTO = new ChatDTO();
		chatDTO = chatservice.searchChatRoom(ids);

		mav.addObject("chatDTO", chatDTO);
		mav.addObject("board", board);
		mav.addObject("id", id);
		return mav;
	}

	@RequestMapping(value="/chat/chatList.do")
	public ModelAndView chatList(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		// TODO Auto-generated method stub
		System.out.println(id + "의 chatList");
		String viewName = (String)request.getAttribute("viewName");
		List<ChatDTO> chatList = chatservice.listchats(id);

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("chatList", chatList);

		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/chat/saveChatContent.do", method=RequestMethod.POST)
	public void saveChatContent(@RequestBody String contentAndid,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("cotroller의 contentAndid : " + contentAndid);
		String id = contentAndid.substring(contentAndid.length() - 1, contentAndid.length());
		String content = contentAndid.substring(0, contentAndid.length()-1);
		System.out.println("id : " + id);
		System.out.println("content : " + content);
		
		Map<String, Object> ids = new HashMap<String, Object>();
		ids.put("content", content);
		ids.put("id", id);
		chatservice.saveChatContent(ids);
	}
}
