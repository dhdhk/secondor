package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryPageHandler;

public interface BoardService {
	List<BoardDTO> listArticles();

	List<BoardDTO> listArticlesByCategory(String category_name);

	public int getCount();

	List<BoardDTO> getPage(Map map);

//	List<BoardDTO> getCategoryPage(CategoryPageHandler ch);
//
//	int getCategoryCount(CategoryPageHandler ch);

	

	
}