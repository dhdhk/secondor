package com.spring.second.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;


	@Override
	public List<BoardDTO> selectAllArticlesList() throws DataAccessException {
		// TODO Auto-generated method stub
		List<BoardDTO> boardList = sqlSession.selectList("mapper.board.selectAllArticleList");

		return boardList;
	}


	@Override
	public List<BoardDTO> selectArticlesByCategory(String category_name) throws DataAccessException {
		// TODO Auto-generated method stub
		List<BoardDTO> ListByCategory = sqlSession.selectList("mapper.board.selectArticleByCategory", category_name);
		System.out.println(category_name + "3");
		return ListByCategory;
	}


	@Override
	public int count() {
	   // TODO Auto-generated method stub
	    return sqlSession.selectOne("mapper.board.count");

	}


	@Override
	public List<BoardDTO> selectPage(Map map) {
	   // TODO Auto-generated method stub
	    return sqlSession.selectList("mapper.board.selectPage", map);
	}
}