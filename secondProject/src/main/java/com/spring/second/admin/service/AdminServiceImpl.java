package com.spring.second.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.admin.DAO.AdminDAO;
import com.spring.second.board.dto.BoardDTO;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDAO adminDAO;
	@Override
	public List<BoardDTO> ListProduct(String search) {
		// TODO Auto-generated method stub
		return adminDAO.selectProductdelete(search);
	}
	@Override
	public void deletepr(String[] deleteselection) {
		// TODO Auto-generated method stub
		adminDAO.prdelete(deleteselection);
	}

}
