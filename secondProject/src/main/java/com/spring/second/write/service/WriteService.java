package com.spring.second.write.service;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface WriteService {

	int addNewArticle(Map<String, Object> articleMap);

}
