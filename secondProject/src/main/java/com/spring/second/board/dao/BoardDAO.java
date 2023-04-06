package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryPageHandler;

public interface BoardDAO {

	List<BoardDTO> selectAllArticlesList() throws DataAccessException;

	List<BoardDTO> selectArticlesByCategory(String category_name)throws DataAccessException;

	public int count();

	public List<BoardDTO> selectPage(Map map);

	

//	public List<BoardDTO> selectArticleByCategory_page(CategoryPageHandler ch);
//
//	int categoryCount(CategoryPageHandler ch);

	
}