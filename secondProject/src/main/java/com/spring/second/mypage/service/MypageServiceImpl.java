package com.spring.second.mypage.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dao.MypageDAO;
import com.spring.second.mypage.dao.MypageDAOImpl;
import com.spring.second.mypage.dto.MyproductlistPage;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired
	MypageDAO mypageDAO;
	
	public void modInfo(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		mypageDAO.updateInfo(memberDTO);
		
	}
//	public List<BoardDTO> selectMyList(String id) {
//		// TODO Auto-generated method stub
//		return mypageDAO.selectMyList(id);
//	}

	//내상품 페이지 (총 상품 갯수)
	public  int getProductListCount(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return mypageDAO.ProductListCount(mp);
	}

	public  List<BoardDTO> getselectMyList(MyproductlistPage mp) {
		// TODO Auto-generated method stub
		return mypageDAO.selectMyList(mp);
	}
	

}