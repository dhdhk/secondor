package com.spring.second.member.service;

import java.util.List;

import com.spring.second.member.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> listMembers();
	void addMember(MemberDTO member);
	void removeMember(String id);
	MemberDTO selectMember(String id);
	void modMember(MemberDTO member);
	MemberDTO login(MemberDTO member);
}
