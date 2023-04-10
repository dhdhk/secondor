package com.spring.second.mypage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

@Service
public class MypageService {
	@Autowired
	MypageDAO mypageDAO;
	public void modInfo(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		mypageDAO.updateInfo(memberDTO);
		
	}
	public List<BoardDTO> selectMyList(String id) {
		// TODO Auto-generated method stub
		return mypageDAO.selectMyList(id);
	}
	

}
