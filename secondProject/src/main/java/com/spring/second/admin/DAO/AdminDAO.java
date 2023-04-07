package com.spring.second.admin.DAO;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;

public interface AdminDAO {

	List<BoardDTO> selectProductdelete(String search);

	void prdelete(String[] deleteselection);

}
