package com.spring.second.mypage.dto;



import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class MyproductlistPage {

	private Integer page=1;
	private String seller_id="";
	private int regNum;
	private Integer start = 1+ (page-1)*10;
    private Integer end =10*page;
    
    public MyproductlistPage() {}
    
    public MyproductlistPage(int totalCnt, Integer page, String seller_id) {
    	
    	this.page=page;
    	this.seller_id=seller_id;
    	
    	System.out.println("mypage:"+ page);
    	System.out.println("seller_id:" + seller_id);
    }
    
    public String getQueryString() {
    	return getQueryString(page);
    }
    
    public String getQueryString(Integer page) {
		// TODO Auto-generated method stub
		return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("seller_id",  seller_id)
                .build().toString();
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart() {
		this.start = 1+ (this.page-1)*10;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd() {
		this.end = 10*this.page;
	}

	@Override
	public String toString() {
		return "MyproductlistPage [page=" + page + ", seller_id=" + seller_id + "]";
	}
    
    
    
}