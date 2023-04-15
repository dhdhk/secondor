package com.spring.second.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.second.member.dto.MemberDTO;

public interface MemberDAO {
	void insertMember(Map<String, Object> memberMap);
	void deleteMember(String id);
	MemberDTO selectMember(String id);
	void updateMember(MemberDTO member);
	MemberDTO loginById(MemberDTO member);
	String find_id(Map<String, String> searchId);
	String find_pw(Map<String, String> searchPw);
	void insertMemberNoimg(Map<String, Object> memberMap);
	int idCheck(String id);
}