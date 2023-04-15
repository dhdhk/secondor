package com.spring.second.mypage.service;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dto.MyproductlistPage;

public interface MypageService {
	public void modInfo(Map<String, Object> memberMap);
	public int getProductListCount(MyproductlistPage mp);
	public List<BoardDTO> getselectMyList(MyproductlistPage mp);
	public void modInfoNoimg(Map<String, Object> memberMap);
}