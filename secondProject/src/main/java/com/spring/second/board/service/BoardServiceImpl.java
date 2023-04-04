package com.spring.second.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.board.dao.BoardDAO;
import com.spring.second.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
   @Autowired
   BoardDAO boardDAO;

   @Override
   public List<BoardDTO> listArticles() {
      // TODO Auto-generated method stub
      List<BoardDTO> boardList = boardDAO.selectAllArticlesList();
      return boardList;
   }

@Override
public int getCount() {
	// TODO Auto-generated method stub
	
	return boardDAO.count();
}

@Override
public List<BoardDTO> getPage(Map map) {
    return boardDAO.selectPage(map);
}


}