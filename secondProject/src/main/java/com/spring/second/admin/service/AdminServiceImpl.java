package com.spring.second.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.admin.DAO.AdminDAO;
import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDAO adminDAO;
	@Override
	public List<BoardDTO> ListProduct(String search) {
		// TODO Auto-generated method stub
		return adminDAO.selectProductdelete(search);
	}
	@Override
	public void deletepr(String[] deleteselection) {
		// TODO Auto-generated method stub
		adminDAO.prdelete(deleteselection);
	}

	//관리자모드- member리스트 불러오기
	@Override
	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		return adminDAO.selectAllMemberList();
	}

	//관리자모드- 회원삭제
	@Override
	public void admindeleteMember(String user_id) {
		// TODO Auto-generated method stub
		adminDAO.admindeleteMember(user_id);
	}
}
