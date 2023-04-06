package com.spring.second.mypage;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;



@Controller
public class MypageController {
	 @Autowired
	 SqlSession sqlSession;
	 
	@RequestMapping(value = "/mypage/mypageMain.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}

	
	@RequestMapping(value = "/board/viewArticle.do")
	public ModelAndView viewArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String viewName = (String) request.getAttribute("viewName");
		List<BoardDTO> boardList = viewArticles();
		ModelAndView mav = new ModelAndView(viewName);
		 mav.addObject("boardList", boardList);
		return mav;
	}


	private List<BoardDTO> viewArticles() {
		// TODO Auto-generated method stub
		List<BoardDTO> boardList = selectviewArticle();
	      return boardList;
	}


	private List<BoardDTO> selectviewArticle() {
		// TODO Auto-generated method stub
		List<BoardDTO> boardList = sqlSession.selectList("mapper.board.selectviewArticle");
	      
	      return boardList;
	}
}
