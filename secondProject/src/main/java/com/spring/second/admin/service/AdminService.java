package com.spring.second.admin.service;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;

public interface AdminService {

	List<BoardDTO> ListProduct(String search);

	void deletepr(String[] deleteselection);


}
