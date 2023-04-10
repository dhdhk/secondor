package com.spring.second.board.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class PageHandler {
	
	int totalCnt; //총 게시물 갯수
	int beginPage; // 첫번째 페이지
	double endPage; // 마지막 페이지
//	private Integer page;
//	private String keyword = "";
//	private Integer start;
//	private Integer end;
//  위에 5가지 전부 불러올 수 있는 SerchCondition받아오기
	private SearchCondition sc;
   
   
   public PageHandler() {}
   
//   public PageHandler(int totalCnt , Integer page) {
//      this.totalCnt = totalCnt;
//      this.page = page;
//      
//      
//     
//      beginPage = page-(page-1)%5; 
//      endPage = (int)Math.ceil((double)totalCnt/20);
//      
//      System.out.println("beginPage :" +beginPage);
//      System.out.println("endpage:" +endPage);
//   }
   
   public PageHandler(int totalCnt, SearchCondition sc) {
	   this.totalCnt = totalCnt;
       this.sc = sc;

       doPaging(totalCnt, sc);
   }
   


private void doPaging(int totalCnt, SearchCondition sc) {
	// TODO Auto-generated method stub
	
	   beginPage = sc.getPage()-(sc.getPage()-1)%5; 
	   endPage = (int)Math.ceil((double)totalCnt/20);
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

   
	public SearchCondition getSc() {
		return sc;
	}
	
	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}

	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", beginPage=" + beginPage + ", endPage=" + endPage + ", sc=" + sc
				+ "]";
	}

   
}