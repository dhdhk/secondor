package com.spring.second.mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dto.MyproductlistPage;

@Repository
public class MypageDAOImpl implements MypageDAO{
	@Autowired
	SqlSession sqlSession;
	
	public void updateInfo(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
		sqlSession.update("mapper.member.updateMember", memberDTO);
	}
	
	/*public List<BoardDTO> selectMyList(String id) {
		// TODO Auto-generated method stub
		List<BoardDTO> dto = sqlSession.selectList("mapper.board.selectMyList",id);
		return dto;
	}*/
	
	//내상품 페이지 (총 상품 갯수)
	public  int ProductListCount(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.MyProductListCount",mp);
	}

	public  List<BoardDTO> selectMyList(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.board.selectMyList",mp);
	}

}