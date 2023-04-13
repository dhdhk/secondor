package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryCondition;
import com.spring.second.board.dto.SearchCondition;
import com.spring.second.comment.dto.CommentDTO;

public interface BoardDAO {
	
	int serchcount(SearchCondition sc);

	List<BoardDTO> serchSelectPage(SearchCondition sc);

	List<BoardDTO> selectByCategoryPage(CategoryCondition cc);

	int CategoryPagecount(CategoryCondition cc);
	
	public Map<String, Object> viewProduct(int regNum);
	
	public List<CommentDTO> commentGet(int regNum);
	
	public List<CommentDTO> buyerCommentsGet(int regNum, String user_id);
}
