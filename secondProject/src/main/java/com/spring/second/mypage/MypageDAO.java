package com.spring.second.mypage;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.member.dto.MemberDTO;

@Repository
public class MypageDAO {
	@Autowired
	private SqlSession sqlSession;
	public void updateInfo(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		
		sqlSession.update("mapper.member.updateMember", memberDTO);
	}

}
