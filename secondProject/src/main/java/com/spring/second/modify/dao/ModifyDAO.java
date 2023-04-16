package com.spring.second.modify.dao;

import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

public interface ModifyDAO {

	void productModify(Map<String, Object> articleMap);

	BoardDTO getfilename(int regNum);

}
