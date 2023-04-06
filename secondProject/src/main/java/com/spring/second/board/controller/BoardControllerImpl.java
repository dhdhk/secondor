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
import com.spring.second.board.dto.CategoryPageHandler;
import com.spring.second.board.dto.PageHandler;
import com.spring.second.board.service.BoardService;

@Controller
public class BoardControllerImpl implements BoardController {
	@Autowired
	BoardService boardService;

    
    @RequestMapping(value="main.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String listArticles(@RequestParam(defaultValue ="1") Integer page , Model m,HttpServletRequest request, HttpServletResponse response) throws Exception
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
		System.out.println(category_name + "1");

		String viewName = (String) request.getAttribute("viewName");
		List<BoardDTO> ListByCategory = boardService.listArticlesByCategory(category_name);

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("ListByCategory", ListByCategory);
		System.out.println(ListByCategory);
		return mav;
	}
	

	//카데고리 페이징 추가 
//	@Override
//	@RequestMapping(value="/viewList.do", method= {RequestMethod.GET, RequestMethod.POST})
//	public String listArticlesByCategory(@RequestParam("category_name") String category_name,CategoryPageHandler ch , Model m,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println(category_name + "1");
//
//		String viewName = (String) request.getAttribute("viewName");
//		List<BoardDTO> ListByCategory = boardService.listArticlesByCategory(category_name);
//
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("ListByCategory", ListByCategory);
//		System.out.println(ListByCategory);
//		return mav;
//		
//		//1.String 값 :category_name 
//		//2. start/end 
//	   
// 
//		System.out.println(category_name + "1");
//		
//		//c_totalcnt를 가져오지 못함..
//		/*
//		 * 이게 아닌가봄 그렇다면 그냥 totalcnt를 가져와야하나?
//		 * 인강 듣고 전체 수정 필요
//		 */
//		
//		int totalCnt = boardService.getCategoryCount(ch);
//	    m.addAttribute("totalCnt",totalCnt);
//	    System.out.println("totlaCnt:"+ totalCnt);
//	   
//	    
//	    PageHandler pageHandler = new PageHandler(totalCnt, ch);
////	    CategoryPageHandler categoryHandler = new CategoryPageHandler(totalCnt, ch);
//	   
//	    
//		/*
//		 * Map map = new HashMap(); map.put("category_name", category_name);
//		 * map.put("start", 1+ (page-1)*20); map.put("end", 20*page);
//		 */
//	    
//	    List<BoardDTO> ListByCategory = boardService.getCategoryPage(ch);
//	    m.addAttribute("ListByCategory", ListByCategory);
//	    m.addAttribute("ph", pageHandler);
//	    
//	    
//	    return "viewList";
//	    
//	}

}