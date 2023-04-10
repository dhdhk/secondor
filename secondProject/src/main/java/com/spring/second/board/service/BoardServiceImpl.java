package com.spring.second.board.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.board.dao.BoardDAO;
import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryCondition;
import com.spring.second.board.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;



	@Override
	public Map<String, Object> viewProduct(int regNum) {
		// TODO Auto-generated method stub
		return boardDAO.viewProduct(regNum);
	}
	
//검색
	@Override
	public List<BoardDTO> getSerchSelectPage(SearchCondition sc) {
	    return boardDAO.serchSelectPage(sc);
	}
	
	@Override
	public int getSerchCount(SearchCondition sc) {
	   // TODO Auto-generated method stub
	   
	   return boardDAO.serchcount(sc);
	}
	
//카테고리
	@Override
	public List<BoardDTO> getselectByCategoryPage(CategoryCondition cc) {
	    return boardDAO.selectByCategoryPage(cc);
	}
	
	@Override
	public int getCategoryPagecount(CategoryCondition cc) {
	   // TODO Auto-generated method stub
	   
	   return boardDAO.CategoryPagecount(cc);
	}

	


}