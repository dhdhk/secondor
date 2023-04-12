package com.spring.second.mypage.dao;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dto.MyproductlistPage;

public interface MypageDAO {
	public void updateInfo(MemberDTO memberDTO);
	int ProductListCount(MyproductlistPage mp);
	List<BoardDTO> selectMyList(MyproductlistPage mp);
}