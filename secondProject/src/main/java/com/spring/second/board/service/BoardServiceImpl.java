package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.second.board.dao.BoardDAO;
import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryPageHandler;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardDTO> listArticles() {
		// TODO Auto-generated method stub
		List<BoardDTO> boardList = boardDAO.selectAllArticlesList();
		return boardList;
	}

	@Override
	public List<BoardDTO> listArticlesByCategory(String category_name) {
		// TODO Auto-generated method stub
		List<BoardDTO> ListByCategory = boardDAO.selectArticlesByCategory(category_name);
		System.out.println(category_name + "2");
		return ListByCategory;
	}

	@Override
	public int getCount() {
	   // TODO Auto-generated method stub
	   
	   return boardDAO.count();
	}

	@Override
	public List<BoardDTO> getPage(Map map) {
	    return boardDAO.selectPage(map);
	}

	

//	@Override
//	public List<BoardDTO> getCategoryPage(CategoryPageHandler ch) {
//		// TODO Auto-generated method stub
//		return boardDAO.selectArticleByCategory_page(ch);
//	}
//
//	@Override
//	public int getCategoryCount(CategoryPageHandler ch) {
//		// TODO Auto-generated method stub
//		return boardDAO.categoryCount(ch);
//	}

}