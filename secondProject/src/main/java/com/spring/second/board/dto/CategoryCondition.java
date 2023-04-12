package com.spring.second.board.dto;

import org.springframework.web.util.UriComponentsBuilder;

public class CategoryCondition {

	private String category_name="";
	private Integer page=1;
	private Integer start = 1+ (page-1)*20;
    private Integer end =20*page;
	
	
    public CategoryCondition() {}
    
    public CategoryCondition(int totalCnt, Integer page, String category_name) {
    	this.page = page;
    	this.category_name= category_name;
    	
    	System.out.println("c_page: " + page);
    	System.out.println("category_name: "+ category_name);
    }
	
    public String getQueryString() {
    	return getQueryString(page);
    }
    
    public String getQueryString(Integer page) {
		// TODO Auto-generated method stub
		return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("category_name",  category_name)
                .build().toString();
	}

	public String getCategory_name() {
		return category_name;
	}

	

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart() {
		this.start = 1+ (this.page-1)*20;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd() {
		this.end = 20*this.page;
	}

	@Override
	public String toString() {
		return "CategoryCondition [category_name=" + category_name + ", page=" + page +  "]";
	}
}
