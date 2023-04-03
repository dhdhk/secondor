package com.spring.second.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.service.BoardService;

@Controller
public class BoardControllerImpl implements BoardController {
   @Autowired
   BoardService boardService;

   @Override
   @RequestMapping(value="main.do", method= {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      String viewName = (String) request.getAttribute("viewName");
      List<BoardDTO> boardList = boardService.listArticles();

      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("boardList", boardList);
      return mav;
   }

   @Override
   @RequestMapping(value="/board/viewList.do", method={RequestMethod.GET, RequestMethod.POST})
   public ModelAndView listArticlesByCategory(@RequestParam("category_name") String category_name,
		   HttpServletRequest request, HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	   String viewName = (String) request.getAttribute("viewName");
	      List<BoardDTO> ListByCategory = boardService.listArticlesByCategory(category_name);
	      
	      ModelAndView mav = new ModelAndView(viewName);
	      mav.addObject("ListByCategory", ListByCategory);
	      return mav;
}
   


}