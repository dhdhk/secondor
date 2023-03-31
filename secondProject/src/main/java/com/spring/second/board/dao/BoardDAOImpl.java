package com.spring.second.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
   @Autowired
   private SqlSession sqlSession;
   
   
   @Override
   public List<BoardDTO> selectAllArticlesList() {
      // TODO Auto-generated method stub
      
      List<BoardDTO> boardList = sqlSession.selectList("mapper.board.selectAllArticleList");
      
      return boardList;
   }

}