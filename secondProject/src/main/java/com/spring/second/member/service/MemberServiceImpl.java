package com.spring.second.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.member.dao.MemberDAO;
import com.spring.second.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	

	@Override
	public void addMember(Map<String, Object> memberMap) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(memberMap);
	}

	@Override
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		memberDAO.deleteMember(id);
	}

	@Override
	public MemberDTO selectMember(String id) {
		// TODO Auto-generated method stub
		return memberDAO.selectMember(id);
	}

	@Override
	public void modMember(MemberDTO member) {
		// TODO Auto-generated method stub
		memberDAO.updateMember(member);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberDAO.loginById(member);
	}

	@Override
	public String find_id(Map<String, String> searchId) {

		return memberDAO.find_id(searchId);
	}

	@Override
	public String find_pw(Map<String, String> searchPw) {
		return memberDAO.find_pw(searchPw);
	}
	@Override
	public void addMemberNoimg(Map<String, Object> memberMap) {
		// TODO Auto-generated method stub
		memberDAO.insertMemberNoimg(memberMap);
	}

	@Override
	public int idCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		int result = memberDAO.idCheck(id);
		return result;
	}
}