package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> listArticles();

	public List<BoardDTO> listArticlesByCategory(String category_name);

	public int getCount();

	public List<BoardDTO> getPage(Map map);
	
	public Map<String, Object> viewProduct(int regNum);
}