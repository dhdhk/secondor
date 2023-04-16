package com.spring.second.modify.service;

import java.util.Map;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.member.dto.MemberDTO;

public interface ModifyService {

	void modifyproduct(Map<String, Object> articleMap);

	BoardDTO getfilename(int regNum);

}
