package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;

public interface BoardDAO {

   List<BoardDTO> selectAllArticlesList();

 public int count();

 public List<BoardDTO> selectPage(Map map);

}