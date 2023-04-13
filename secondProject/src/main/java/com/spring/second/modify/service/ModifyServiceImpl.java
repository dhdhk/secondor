package com.spring.second.modify.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.modify.dao.ModifyDAO;
@Service
public class ModifyServiceImpl implements ModifyService{
	@Autowired
	ModifyDAO modifyDAO;
	
	@Override
	public void modifyproduct(Map<String, Object> articleMap) {
		// TODO Auto-generated method stub
		modifyDAO.productModify(articleMap);
	}

}
