package com.spring.second.mypage;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.member.dto.MemberDTO;

@Service
public class MypageService {
	@Autowired
	MypageDAO mypageDAO;
	public void modInfo(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		mypageDAO.updateInfo(memberDTO);
		
	}
	

}
