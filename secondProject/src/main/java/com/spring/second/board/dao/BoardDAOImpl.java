package com.spring.second.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.board.dto.CategoryCondition;
import com.spring.second.board.dto.SearchCondition;
import com.spring.second.comment.dto.CommentDTO;
import com.spring.second.write.dto.ImageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;

//검색
	@Override
	public List<BoardDTO> serchSelectPage(SearchCondition sc) {
	   // TODO Auto-generated method stub
	    return sqlSession.selectList("mapper.board.serchSelectPage", sc);
	}

	@Override
	public int serchcount(SearchCondition sc) {
	   // TODO Auto-generated method stub
	    return sqlSession.selectOne("mapper.board.serchcount",sc);

	}

//카데고리
	
	@Override
	public List<BoardDTO> selectByCategoryPage(CategoryCondition cc) {
	   // TODO Auto-generated method stub
	    return sqlSession.selectList("mapper.board.selectByCategoryPage", cc);
	}

	@Override
	public int CategoryPagecount(CategoryCondition cc) {
	   // TODO Auto-generated method stub
	    return sqlSession.selectOne("mapper.board.CategoryPagecount",cc);

	}


//상세페이지
	@Override
	public Map<String, Object> viewProduct(int regNum) {
		// TODO Auto-generated method stub
		BoardDTO product = sqlSession.selectOne("mapper.board.selectProduct", regNum);
		//List<ImageDTO> imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", regNum);
		
		Map<String, Object> productMap = new HashMap<String, Object>();
		productMap.put("product", product);
		//productMap.put("imageFileList", imageFileList);
		return productMap;
	}
	
	//댓글용
	@Override
	public List<CommentDTO> commentGet(int regNum) {
		// TODO Auto-generated method stub
		List<CommentDTO> commentList=sqlSession.selectList("mapper.comment.commentList", regNum);
		return commentList;
	}

	@Override
	public List<CommentDTO> buyerCommentsGet(int regNum, String user_id) {
		// TODO Auto-generated method stub
		Map<String, Object> buyerComments= new HashMap<String, Object>();
		buyerComments.put("regNum", regNum);
		buyerComments.put("buyer_id", user_id);
		List<CommentDTO> buyerCommentList=sqlSession.selectList("mapper.comment.buyercommentList",buyerComments);
		return buyerCommentList;
	}
}