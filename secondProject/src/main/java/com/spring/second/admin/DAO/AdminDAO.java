package com.spring.second.admin.DAO;

import java.util.List;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

public interface AdminDAO {

	List<BoardDTO> selectProductdelete(String search);

	void prdelete(String[] deleteselection);

	List<MemberDTO> selectAllMemberList();

	void admindeleteMember(String user_id);

}
