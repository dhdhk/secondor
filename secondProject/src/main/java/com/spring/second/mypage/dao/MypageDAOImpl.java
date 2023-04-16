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

	//마이페이지 페이징 (내상품 리스트 갯수)
	public  int ProductListCount(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.MyProductListCount",mp);
	}

	//마이페이지 페이징 (내상품 리스트 불러오기)
	public  List<BoardDTO> selectMyList(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.board.selectMyList",mp);
	}
	
	

	@Override
	public void updateInfo(Map<String, Object> memberMap) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.member.updateMember", memberMap);
	}

	@Override
	public void updateInfoNoimg(Map<String, Object> memberMap) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.member.updateMemberNoimg", memberMap);
	}
	
	public String getprofilename(MemberDTO member) {
		return sqlSession.selectOne("mapper.member.getprofilename",member);
	}

	
	
	
}