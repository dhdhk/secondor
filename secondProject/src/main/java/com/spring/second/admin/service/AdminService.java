package com.spring.second.admin.service;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

public interface AdminService {

	List<BoardDTO> ListProduct(String search);

	void deletepr(String[] deleteselection);

	List<MemberDTO> listMembers();

	void admindeleteMember(String user_id);


}
