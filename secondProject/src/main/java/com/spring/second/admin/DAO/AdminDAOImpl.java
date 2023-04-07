package com.spring.second.admin.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> selectProductdelete(String search) {
		// TODO Auto-generated method stub
		List<BoardDTO> productList;
		if(search.length()!=0) {
			productList = sqlSession.selectList("mapper.board.selectProductdelete", search);
		}else {
			productList = sqlSession.selectList("mapper.board.ProductList");
		}
		return productList;
	}

	@Override
	public void prdelete(String[] deleteselection) {
		// TODO Auto-generated method stub
		for(int i=0;i<deleteselection.length;i++) {
			sqlSession.delete("mapper.board.prdelete", Integer.parseInt(deleteselection[i]));
		}
	}

}
