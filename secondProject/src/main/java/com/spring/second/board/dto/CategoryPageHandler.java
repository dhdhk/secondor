package com.spring.second.board.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CategoryPageHandler {

	   int totalCnt; //카테고리별 전체 갯수
	   int beginPage; // 첫번째 페이지
	   double endPage; // 마지막 페이지
	   private Integer page=1; //현재 페이지
	   private String category_name="";
	     



	  public CategoryPageHandler() {}
	   
	
	
	   public CategoryPageHandler(int totalCnt , Integer page, String category_name) {
	      this.totalCnt = totalCnt;
	      this.page = page;
	      this.category_name= category_name;
	      
	      
	     System.out.println("totalCnt :" +totalCnt);
	     System.out.println("category_name :" +category_name);
	      beginPage = page-(page-1)%5; 
	      endPage = (int)Math.ceil((double)totalCnt/20);
	      
	      System.out.println("beginPage :" +beginPage);
	      System.out.println("endpage:" +endPage);
	   }


    public String getQueryString() {
	        return getQueryString(page);
	    }

	private String getQueryString(Integer page) {
		// TODO Auto-generated method stub
		//viewList.do?category_name=living&page=1
		return UriComponentsBuilder.newInstance()
                .queryParam("category_name", category_name)
                .queryParam("page", page)
                .build().toString();
    
	}


	public int getC_totalCnt() {
		return totalCnt;
	}

	public void setC_totalCnt(int c_totalCnt) {
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	   
	   
    public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
