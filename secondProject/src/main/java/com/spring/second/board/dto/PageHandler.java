package com.spring.second.board.dto;

import org.springframework.stereotype.Component;


@Component
public class PageHandler {
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
      
      
      endPage = (double)Math.ceil(totalCnt/10);
      beginPage = page-(page-1)%5; 
      
      System.out.println("beginPage :" +beginPage);
      System.out.println("endpage:" +endPage);
   }
   
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