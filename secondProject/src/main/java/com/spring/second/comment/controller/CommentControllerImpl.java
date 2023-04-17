package com.spring.second.comment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.comment.service.CommentService;
import com.spring.second.member.dto.MemberDTO;
@Controller
public class CommentControllerImpl implements CommentController{
	@Autowired
	CommentService commentService;
	
	//판매자용 댓글 작성
	@RequestMapping(value="/product/SellerWriteComment.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView SellerWriteComment(@RequestParam("regNum") int regNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> commentWrite=new HashMap<String, Object>();
		List<String> buyers= commentService.buyerCounting(regNum);
		int commentNo=commentService.getcommentNo();
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String seller_id=commentService.getSellerId(regNum);
		if(member.getUser_id().equals(seller_id)) {
			commentWrite.put("comment_writer", "seller");
		}else {
			commentWrite.put("comment_writer", "buyer");
		}
		commentWrite.put("seller_id", seller_id);
		commentWrite.put("regNum", regNum);
		commentWrite.put("commentNo", commentNo+1);
		int cont=0;
		for(int i=0;i<buyers.size();i++) {
			if(request.getParameter("comment_content"+i).length()==0) {
				cont++;
			}else {
				commentWrite.put("comment_content",request.getParameter("comment_content"+i));
				commentWrite.put("buyer_id",buyers.get(i));
				Map<String, Object> findPlusNo=new HashMap<String, Object>();
				findPlusNo.put("regNum", regNum);
				findPlusNo.put("buyer_id", buyers.get(i));
				int comment_plusNo=commentService.getPlusNo(findPlusNo);
				commentWrite.put("comment_plusNo", comment_plusNo+1);
				for(String key : commentWrite.keySet()) {
					Object value = (Object) commentWrite.get(key);
			        System.out.println(key + " : " + value);
			    }
					commentService.addPlusComment(commentWrite);
					break;
			}
			System.out.println(cont);
			if(cont==buyers.size()) {
				break;
			}
		}
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/product/viewProduct.do?regNum="+regNum);
		return mav;
}


	//구매자용 댓글 작성
	@RequestMapping(value="/product/buyerWriteComment.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView buyerWriteComment(@RequestParam("regNum") int regNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> commentWrite=new HashMap<String, Object>();
		int commentNo=commentService.getcommentNo();
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		String seller_id=commentService.getSellerId(regNum);
		if(member.getUser_id().equals(seller_id)) {
			commentWrite.put("comment_writer", "seller");
		}else {
			commentWrite.put("comment_writer", "buyer");
		}
		commentWrite.put("seller_id", seller_id);
		commentWrite.put("regNum", regNum);
		commentWrite.put("commentNo", commentNo+1);
		if(request.getParameter("comment_content10").length()!=0) {
			commentWrite.put("comment_content",request.getParameter("comment_content10"));
			Map<String, Object> findPlusNo=new HashMap<String, Object>();
			findPlusNo.put("regNum", regNum);
			findPlusNo.put("buyer_id", member.getUser_id());
			int comment_plusNo=commentService.getPlusNo(findPlusNo);
			commentWrite.put("comment_plusNo", comment_plusNo+1);
			commentWrite.put("buyer_id", member.getUser_id());
			for(String key : commentWrite.keySet()) {
				Object value = (Object) commentWrite.get(key);
		        System.out.println(key + " : " + value);
			}
			commentService.addPlusComment(commentWrite);//알림 카운트용
			commentService.addBoardCnt(regNum);//알림 카운트용
			commentService.addUserCnt(seller_id);
		}else {
			
		}
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/product/viewProduct.do?regNum="+regNum);
		return mav;
	}
	
	//댓글 삭제용
	@RequestMapping(value="/product/deleteComment.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(@RequestParam("regNum") int regNum, @RequestParam("commentNo") Object commentNo,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(commentNo);
		commentService.commentDelete(commentNo);
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/product/viewProduct.do?regNum="+regNum);
		return mav;
	}
}
