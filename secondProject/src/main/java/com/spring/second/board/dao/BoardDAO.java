package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.second.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectAllArticlesList() throws DataAccessException;

	List<BoardDTO> selectArticlesByCategory(String category_name)throws DataAccessException;

	public int count();

	public List<BoardDTO> selectPage(Map map);
}