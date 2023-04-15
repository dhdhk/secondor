package com.spring.second.mypage.dao;

import java.util.List;
import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dto.MyproductlistPage;

public interface MypageDAO {
	public void updateInfo(Map<String, Object> memberMap);
	int ProductListCount(MyproductlistPage mp);
	List<BoardDTO> selectMyList(MyproductlistPage mp);
	public void updateInfoNoimg(Map<String, Object> memberMap);
}