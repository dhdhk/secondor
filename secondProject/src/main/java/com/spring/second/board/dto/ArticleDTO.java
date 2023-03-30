package com.spring.second.board.dto;

import java.sql.Date;

public class ArticleDTO {
	private String seller_id;
	private String pr_title;
	private String pr_price;
	private String pr_img1;
	private String pr_img2;
	private String pr_img3;
	private String pr_content;
	private String pr_condition;
	private String pr_sold;
	private Date regDate;
	private int regNum;
	private String category_name;
	
	
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getPr_title() {
		return pr_title;
	}
	public void setPr_title(String pr_title) {
		this.pr_title = pr_title;
	}
	public String getPr_price() {
		return pr_price;
	}
	public void setPr_price(String pr_price) {
		this.pr_price = pr_price;
	}
	public String getPr_img1() {
		return pr_img1;
	}
	public void setPr_img1(String pr_img1) {
		this.pr_img1 = pr_img1;
	}
	public String getPr_img2() {
		return pr_img2;
	}
	public void setPr_img2(String pr_img2) {
		this.pr_img2 = pr_img2;
	}
	public String getPr_img3() {
		return pr_img3;
	}
	public void setPr_img3(String pr_img3) {
		this.pr_img3 = pr_img3;
	}
	public String getPr_content() {
		return pr_content;
	}
	public void setPr_content(String pr_content) {
		this.pr_content = pr_content;
	}
	public String getPr_condition() {
		return pr_condition;
	}
	public void setPr_condition(String pr_condition) {
		this.pr_condition = pr_condition;
	}
	public String getPr_sold() {
		return pr_sold;
	}
	public void setPr_sold(String pr_sold) {
		this.pr_sold = pr_sold;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
