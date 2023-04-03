package com.spring.second.board.dao;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;

public interface BoardDAO {

   List<BoardDTO> selectAllArticlesList();

   List<BoardDTO> selectArticlesByCategory(String category_name);

}