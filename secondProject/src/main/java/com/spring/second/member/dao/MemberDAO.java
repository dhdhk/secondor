package com.spring.second.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.second.member.dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> selectAllMemberList() throws DataAccessException;
	void insertMember(MemberDTO member);
	void deleteMember(String id);
	MemberDTO selectMember(String id);
	void updateMember(MemberDTO member);
	MemberDTO loginById(MemberDTO member);
}