package com.spring.second.modify.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;
@Repository
public class ModifyDAOImpl implements ModifyDAO{
	@Autowired
	SqlSession sqlSession;
	@Autowired
	BoardDTO boardDTO;
	
	@Override
	public void productModify(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.modify.productsModify", articleMap);
		if(articleMap.get("pr_img1")!=null) {
			sqlSession.update("mapper.modify.modifyImg1", articleMap);
		}
		if(articleMap.get("pr_img2")!=null) {
			sqlSession.update("mapper.modify.modifyImg2", articleMap);
		}
		if(articleMap.get("pr_img3")!=null) {
			sqlSession.update("mapper.modify.modifyImg3", articleMap);
		}
	}

	@Override
	public BoardDTO getfilename(int regNum) {
		// TODO Auto-generated method stub
		boardDTO=sqlSession.selectOne("mapper.modify.getfilename", regNum);
		return boardDTO;
	}

}
