package com.spring.second.comment.dto;

import java.sql.Date;

public class CommentDTO {
	private int commentNo;
	private String buyer_id;
	private String solder_id;
	private int regNum;
	private Date regDate;
	private String comment_content;
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getSolder_id() {
		return solder_id;
	}
	public void setSolder_id(String solder_id) {
		this.solder_id = solder_id;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
}
