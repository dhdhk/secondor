package com.spring.second.member.service;

import java.util.List;
import java.util.Map;

import com.spring.second.member.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> listMembers();
	void addMember(Map<String, Object> memberMap);
	void removeMember(String id);
	MemberDTO selectMember(String id);
	void modMember(MemberDTO member);
	MemberDTO login(MemberDTO member);
	public String find_id(Map<String, String> searchId);
	public String find_pw(Map<String, String> searchPw);
	void addMemberNoimg(Map<String, Object> memberMap);
	int idCheck (String id) throws Exception;
}