package com.spring.second.admin.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> selectProductdelete(String search) {
		// TODO Auto-generated method stub
		List<BoardDTO> productList;
		if(search.length()!=0) {
			productList = sqlSession.selectList("mapper.admin.selectProductdelete", search);
		}else {
			productList = sqlSession.selectList("mapper.admin.ProductList");
		}
		return productList;
	}

	@Override
	public void prdelete(String[] deleteselection) {
		// TODO Auto-generated method stub
		for(int i=0;i<deleteselection.length;i++) {
			sqlSession.delete("mapper.admin.prdelete", Integer.parseInt(deleteselection[i]));
		}
	}
	
	//관리자모드- member리스트 불러오기
	@Override
	public List<MemberDTO> selectAllMemberList() throws DataAccessException {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = sqlSession.selectList("mapper.admin.selectAllMemberList");
		return membersList;
	}

	//관리자모드- 회원삭제
	@Override
	public void adminDeleteMember(String user_id) {
		// TODO Auto-generated method stub
		 sqlSession.delete("mapper.admin.adminDeleteMember", user_id);
	}

}
