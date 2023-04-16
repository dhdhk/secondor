package com.spring.second.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.comment.dto.CommentDTO;
@Repository
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	SqlSession sqlSession;
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

		@Override
		public List<String> buyerCounts(int regNum) {
			// TODO Auto-generated method stub
			List<String> buyersGet=sqlSession.selectList("mapper.comment.buyers",regNum);
			return buyersGet;
		}

		@Override
		public int commentNoGet() {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("mapper.comment.NewCommentNo");
		}

		@Override
		public int plusNoGet(Map<String, Object> findPlusNo) {
			// TODO Auto-generated method stu
			int No;
			if(sqlSession.selectOne("mapper.comment.NewCommentPlusNo", findPlusNo)==null) {
				No=0;
			}
			else {
				No=sqlSession.selectOne("mapper.comment.NewCommentPlusNo", findPlusNo);
			}
			return No;
		}

		@Override
		public void plusCommentAdd(Map<String, Object> commentWrite) {
			// TODO Auto-generated method stub
			sqlSession.insert("mapper.comment.addPlusComment", commentWrite);
		}

		@Override
		public String sellerIdGet(int regNum) {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("mapper.admin.selectSellerId", regNum);
		}

		@Override
		public void deleteComment(Object commentNo) {
			// TODO Auto-generated method stub
			sqlSession.delete("mapper.comment.deleteComment", commentNo);
		}

		@Override
		public void boardCntAdd(int regNum) {
			// TODO Auto-generated method stub
			sqlSession.update("mapper.comment.addBoardCnt", regNum);
		}

		@Override
		public void userCntAddd(String user_id) {
			// TODO Auto-generated method stub
			sqlSession.update("mapper.comment.addUserCnt", user_id);
			System.out.println(user_id);
		}
}
