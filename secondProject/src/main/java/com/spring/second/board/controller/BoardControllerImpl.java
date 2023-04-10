package com.spring.second.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.PageHandler;
import com.spring.second.board.service.BoardService;

@Controller
public class BoardControllerImpl implements BoardController {
	@Autowired
	BoardService boardService;


	@RequestMapping(value="main.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String listArticles(@RequestParam(defaultValue ="1") Integer page , Model m,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{ 

		int totalCnt = boardService.getCount();
		m.addAttribute("totalCnt",totalCnt);
		System.out.println(totalCnt);

		PageHandler pageHandler = new PageHandler(totalCnt, page);


		Map map  = new HashMap();
		map.put("start", 1+ (page-1)*20);
		map.put("end", 20*page);

		List<BoardDTO> boardList = boardService.getPage(map);
		m.addAttribute("boardList", boardList);
		m.addAttribute("ph", pageHandler);


		return "main";

	}


	@Override
	@RequestMapping(value="/viewList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticlesByCategory(@RequestParam("category_name") String category_name,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String viewName = (String) request.getAttribute("viewName");
		List<BoardDTO> ListByCategory = boardService.listArticlesByCategory(category_name);

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("ListByCategory", ListByCategory);
		return mav;
	}


		@Override
		@RequestMapping(value="/product/viewProduct.do", method= {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView viewProduct(@RequestParam("regNum") int regNum,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
	
			String viewName = (String) request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView(viewName);
	
			Map<String, Object> productMap = boardService.viewProduct(regNum); 
			mav.addObject("productMap", productMap);
			return mav;
		}
		


}
