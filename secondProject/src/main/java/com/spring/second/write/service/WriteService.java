package com.spring.second.write.service;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface WriteService {

	void addNewArticle(Map<String, Object> articleMap);
	public int addNewRegNum();

}
