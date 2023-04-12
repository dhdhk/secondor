package com.spring.second.mypage.dto;

public class MypageHandler {

	int totalCnt;
	int beginPage;
	double endPage;
	private MyproductlistPage mp;
	
	public MypageHandler() {}
	
	public MypageHandler(int totalCnt, MyproductlistPage mp) {
		this.totalCnt= totalCnt;
		this.mp = mp;
		
		dopaging(totalCnt,mp);
	}

	private void dopaging(int totalCnt, MyproductlistPage mp) {
		// TODO Auto-generated method stub
		beginPage=mp.getPage()-(mp.getPage()-1)%5;
		endPage=(int)Math.ceil((double)totalCnt/10); //리스트 10개씩 보이게 했으니까 10으로 나눠주기
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

	public MyproductlistPage getMp() {
		return mp;
	}

	public void setMp(MyproductlistPage mp) {
		this.mp = mp;
	}

	@Override
	public String toString() {
		return "MypageHandler [totalCnt=" + totalCnt + ", beginPage=" + beginPage + ", endPage=" + endPage + ", mp="
				+ mp + "]";
	}
	
	
}
