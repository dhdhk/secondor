package com.spring.second.comment.dao;

import java.util.List;
import java.util.Map;

import com.spring.second.comment.dto.CommentDTO;

public interface CommentDAO {
public List<CommentDTO> commentGet(int regNum);
	
	public List<CommentDTO> buyerCommentsGet(int regNum, String user_id);

	public List<String> buyerCounts(int regNum);

	public int commentNoGet();

	public int plusNoGet(Map<String, Object> findPlusNo);

	public void plusCommentAdd(Map<String, Object> commentWrite);

	public String sellerIdGet(int regNum);

	public void deleteComment(Object commentNo);

	public void boardCntAdd(int regNum);

	public void userCntAddd(String user_id);
}
