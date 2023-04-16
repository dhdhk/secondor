package com.spring.second.mypage.service;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
import com.spring.second.mypage.dao.MypageDAO;
import com.spring.second.mypage.dto.MyproductlistPage;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageDAO mypageDAO;
	
	//내상품 페이지 (총 상품 갯수)
		public  int getProductListCount(MyproductlistPage mp) {
			// TODO Auto-generated method stub
			return mypageDAO.ProductListCount(mp);
		}

		//내상품 페이지 리스트
		public  List<BoardDTO> getselectMyList(MyproductlistPage mp) {
			// TODO Auto-generated method stub
			return mypageDAO.selectMyList(mp);
		}

		@Override
		public void modInfo(Map<String, Object> memberMap) {
			// TODO Auto-generated method stub
			mypageDAO.updateInfo(memberMap);
		}

		@Override
		public void modInfoNoimg(Map<String, Object> memberMap) {
			// TODO Auto-generated method stub
			mypageDAO.updateInfoNoimg(memberMap);
		}

		@Override
		public String getprofilename(MemberDTO member) {
			// TODO Auto-generated method stub
			return mypageDAO.getprofilename(member);
		}
	

}