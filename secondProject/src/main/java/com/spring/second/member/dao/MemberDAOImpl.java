package com.spring.second.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.second.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MemberDTO> selectAllMemberList() throws DataAccessException {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public void insertMember(MemberDTO member) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("mapper.member.deleteMember", id);
	}

	@Override
	public MemberDTO selectMember(String id) {
		// TODO Auto-generated method stub
		MemberDTO dto = (MemberDTO) sqlSession.selectOne("mapper.member.selectMember", id);
		System.out.println(dto.getUser_id());
		return dto;
	}

	@Override
	public void updateMember(MemberDTO member) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("mapper.member.updateMember", member);
	}

	@Override
	public MemberDTO loginById(MemberDTO member) {
		// TODO Auto-generated method stub
		member = sqlSession.selectOne("mapper.member.loginById", member);
		return member;
	}
}
