package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.SearchCondition;

public interface BoardDAO {

	List<BoardDTO> selectAllArticlesList() throws DataAccessException;

	List<BoardDTO> selectArticlesByCategory(String category_name)throws DataAccessException;

	public int count();

	public List<BoardDTO> selectPage(Map map);

	int serchcount(SearchCondition sc);

	List<BoardDTO> serchSelectPage(SearchCondition sc);
	
//	public Map<String, Object> viewProduct(int regNum);
}
