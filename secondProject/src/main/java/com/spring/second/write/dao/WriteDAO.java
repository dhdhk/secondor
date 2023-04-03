package com.spring.second.write.dao;

import java.util.Map;

public interface WriteDAO {

	int insertNewArticle(Map<String, Object> articleMap);

	void insertNewImage(Map<String, Object> articleMap);

}
