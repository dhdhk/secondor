package com.spring.second.write.dao;

import java.util.Map;

public interface WriteDAO {

	void insertNewArticle(Map<String, Object> articleMap);
	int selectNewRegNum();
	void insertNewImage(Map<String, Object> articleMap);

}
