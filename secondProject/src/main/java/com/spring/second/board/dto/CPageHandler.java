package com.spring.second.board.dto;

import org.springframework.stereotype.Component;

@Component
public class CPageHandler {

	int totalCnt;
	int beginPage;
	double endPage;
	private CategoryCondition cc;
	
	public CPageHandler() {}
	
	public CPageHandler(int totalCnt, CategoryCondition cc) {
		this.totalCnt = totalCnt;
		this.cc= cc;
		
		dopaing(totalCnt, cc);
	}

	private void dopaing(int totalCnt, CategoryCondition cc) {
		// TODO Auto-generated method stub
		
		beginPage = cc.getPage()-(cc.getPage()-1)%5;
		endPage =(int)Math.ceil((double)totalCnt/20);
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public double getEndPage() {
		return endPage;
	}

	public void setEndPage(double endPage) {
		this.endPage = endPage;
	}

	public CategoryCondition getCc() {
		return cc;
	}

	public void setCc(CategoryCondition cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "CPageHandler [totalCnt=" + totalCnt + ", beginPage=" + beginPage + ", endPage=" + endPage + ", cc=" + cc
				+ "]";
	}
	
	
	
}
