package com.spring.second.board.service;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;

public interface BoardService {
   List<BoardDTO> listArticles();

List<BoardDTO> listArticlesByCategory(String category_name);

}