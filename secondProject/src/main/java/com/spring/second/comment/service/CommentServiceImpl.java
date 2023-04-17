package com.spring.second.comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.comment.dao.CommentDAO;
import com.spring.second.comment.dto.CommentDTO;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDAO commentDAO;
	//댓글
			@Override
			public List<CommentDTO> viewComment(int regNum) {
				// TODO Auto-generated method stub
				return commentDAO.commentGet(regNum);
			}

			@Override
			public List<CommentDTO> viewbuyerComments(int regNum, String user_id) {
				// TODO Auto-generated method stub
				return commentDAO.buyerCommentsGet(regNum, user_id);
			}

			@Override
			public List<String> buyerCounting(int regNum) {
				// TODO Auto-generated method stub
				return commentDAO.buyerCounts(regNum);
			}

			@Override
			public int getcommentNo() {
				// TODO Auto-generated method stub
				return commentDAO.commentNoGet();
			}

			@Override
			public int getPlusNo(Map<String, Object> findPlusNo) {
				// TODO Auto-generated method stub
				return commentDAO.plusNoGet(findPlusNo);
			}

			@Override
			public void addPlusComment(Map<String, Object> commentWrite) {
				// TODO Auto-generated method stub
				commentDAO.plusCommentAdd(commentWrite);
			}

			@Override
			public String getSellerId(int regNum) {
				// TODO Auto-generated method stub
				return commentDAO.sellerIdGet(regNum);
			}

			@Override
			public void commentDelete(Object commentNo) {
				// TODO Auto-generated method stub
				commentDAO.deleteComment(commentNo);
			}

			@Override
			public void addBoardCnt(int regNum) {
				// TODO Auto-generated method stub
				commentDAO.boardCntAdd(regNum);
			}

			@Override
			public void addUserCnt(String seller_id) {
				// TODO Auto-generated method stub
				commentDAO.userCntAddd(seller_id);
			}

			@Override
			public void addUser(String user_id) {
				// TODO Auto-generated method stub
				commentDAO.userAdd(user_id);
			}

			@Override
			public void addArticle(int regNum) {
				// TODO Auto-generated method stub
				commentDAO.articleAdd(regNum);
			}

			@Override
			public int getBoardCommentCnt(int regNum) {
				// TODO Auto-generated method stub
				return commentDAO.boardCommentCntGet(regNum);
			}

			@Override
			public void minusUserCommentCnt(String seller_id, int brdcmtcnt) {
				// TODO Auto-generated method stub
				commentDAO.userCommentCntMinus(seller_id, brdcmtcnt);
			}
}
