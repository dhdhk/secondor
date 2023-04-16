package com.spring.second.comment.dto;

public class UserCommentCntDTO {
	private String user_id;
	private int userCommentCount;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getUserCommentCount() {
		return userCommentCount;
	}
	public void setUserCommentCount(int userCommentCount) {
		this.userCommentCount = userCommentCount;
	}
}
