package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryCondition;
import com.spring.second.board.dto.SearchCondition;

public interface BoardService {
	
	List<BoardDTO> getSerchSelectPage(SearchCondition sc);

	int getSerchCount(SearchCondition sc);

	List<BoardDTO> getselectByCategoryPage(CategoryCondition cc);

	int getCategoryPagecount(CategoryCondition cc);
	
	public Map<String, Object> viewProduct(int regNum);
}
