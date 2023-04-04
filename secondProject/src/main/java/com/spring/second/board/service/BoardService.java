package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;

public interface BoardService {
   List<BoardDTO> listArticles();

	int getCount();

	List<BoardDTO> getPage(Map map); 

}