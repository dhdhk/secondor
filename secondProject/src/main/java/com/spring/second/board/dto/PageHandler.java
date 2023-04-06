package com.spring.second.board.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class PageHandler {
   private CategoryPageHandler ch;
   int totalCnt; //총 게시물 갯수
   //double totalPage; //전체 페이지의 갯수
   //int page; //현재페이지 
   int beginPage; // 첫번째 페이지
   double endPage; // 마지막 페이지
   private Integer page;
   
   
   public PageHandler() {}
   
   public PageHandler(int totalCnt , Integer page) {
      this.totalCnt = totalCnt;
      this.page = page;
      
      
     
      beginPage = page-(page-1)%5; 
      endPage = (int)Math.ceil((double)totalCnt/20);
      
      System.out.println("beginPage :" +beginPage);
      System.out.println("endpage:" +endPage);
   }
   
   
   
//   public PageHandler(int totalCnt, CategoryPageHandler ch) {
//	// TODO Auto-generated constructor stub
//	   this.totalCnt = totalCnt;
//	   this.page = page;
//	   
//	   doPaging(totalCnt, ch);
//   }
//
//private void doPaging(int totalCnt, CategoryPageHandler ch) {
//	// TODO Auto-generated method stub
//	beginPage = page-(page-1)%5; 
//    endPage = (int)Math.ceil((double)totalCnt/20);
//    
//    System.out.println("beginPage2 : " +beginPage);
//    System.out.println("endpage2 : " +endPage);
//}
//
//
//public String getQueryString() {
//    return getQueryString(this.ch.getPage());
//}
//
//
//
//private String getQueryString(Integer page) {
//	// TODO Auto-generated method stub
//	return UriComponentsBuilder.newInstance()
//            .queryParam("category_name", ch.getCategory_name())
//            .queryParam("page", page)
//            .build().toString();
//}

public int getTotalCnt() {
      return totalCnt;
   }




   public void setTotalCnt(int totalCnt) {
      this.totalCnt = totalCnt;
   }




   public int getPage() {
      return page;
   }




   public void setPage(int page) {
      this.page = page;
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




   



}