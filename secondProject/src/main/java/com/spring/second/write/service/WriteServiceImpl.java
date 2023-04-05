package com.spring.second.write.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.write.dao.WriteDAO;

@Service
public class WriteServiceImpl implements WriteService{
	@Autowired
	WriteDAO writeDAO;
	
	@Override
	public void addNewArticle(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		writeDAO.insertNewArticle(articleMap);
		writeDAO.insertNewImage(articleMap);
	}
	
	@Override
	public int addNewRegNum() {
		return writeDAO.selectNewRegNum();
	}


}
