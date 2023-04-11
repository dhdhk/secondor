package com.spring.second.board.controller;

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
import com.spring.second.board.dto.CPageHandler;
import com.spring.second.board.dto.CategoryCondition;
import com.spring.second.board.dto.PageHandler;
import com.spring.second.board.dto.SearchCondition;
import com.spring.second.board.service.BoardService;

@Controller
public class BoardControllerImpl implements BoardController {
	@Autowired
	BoardService boardService;


	@RequestMapping(value="main.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String listArticles(SearchCondition sc , Model m,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{ 

		int totalCnt = boardService.getSerchCount(sc);
		m.addAttribute("totalCnt",totalCnt);
		System.out.println(totalCnt);
		System.out.println(sc);
		sc.setStart();
		sc.setEnd();
		System.out.println("page : " + sc.getPage());
		System.out.println("start : " + sc.getStart());
		System.out.println("end : " + sc.getEnd());
		PageHandler pageHandler = new PageHandler(totalCnt,sc);


		List<BoardDTO> boardList = boardService.getSerchSelectPage(sc);
		m.addAttribute("boardList", boardList);
		m.addAttribute("ph", pageHandler);


		return "main";

	}


	@Override
	@RequestMapping(value="/viewList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String listArticlesByCategory(CategoryCondition cc,Model m,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		int totalCnt = boardService.getCategoryPagecount(cc);
		m.addAttribute("totalCnt",totalCnt);
		System.out.println("c_totalCnt: "+totalCnt);
		System.out.println("cc: "+cc);
		cc.setStart();
		cc.setEnd();
		System.out.println("page : " + cc.getPage());
		System.out.println("start : " + cc.getStart());
		System.out.println("end : " + cc.getEnd());
		CPageHandler cpageHandler = new CPageHandler(totalCnt,cc);




		List<BoardDTO> ListByCategory = boardService.getselectByCategoryPage(cc);
		m.addAttribute("ListByCategory", ListByCategory);
		m.addAttribute("ch", cpageHandler);

		return "viewList";


	}	


		@Override
		@RequestMapping(value="/product/viewProduct.do", method= {RequestMethod.GET, RequestMethod.POST})
		public ModelAndView viewProduct(@RequestParam("regNum") int regNum,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
	
			System.out.println("regNum: " + regNum);
			String viewName = (String) request.getAttribute("viewName");
			ModelAndView mav = new ModelAndView(viewName);
	
			Map<String, Object> productMap = boardService.viewProduct(regNum); 
			mav.addObject("productMap", productMap);
			return mav;
		}


}