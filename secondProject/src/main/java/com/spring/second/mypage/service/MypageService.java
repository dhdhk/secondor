package com.spring.second.mypage.service;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dto.MyproductlistPage;

public interface MypageService {
	public void modInfo(MemberDTO memberDTO);
	public int getProductListCount(MyproductlistPage mp);
	public List<BoardDTO> getselectMyList(MyproductlistPage mp);
}
