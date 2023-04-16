package com.spring.second.chat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.second.chat.dto.ChatDTO;

@Repository
public class ChatDAO {
	@Autowired
	private SqlSession sqlSession;

	public ChatDTO selectChatRoom(Map<String, Object> ids) {
		// TODO Auto-generated method stub
		ChatDTO dto = (ChatDTO) sqlSession.selectOne("mapper.chat.selectChatRoom", ids);
		//System.out.println("대화방 검색 작업 : " + dto.getChat_id());
		if(dto == null) {
			System.out.println("새로운 대화방 생성!");
			insertNewChatRoom(ids);
			dto = (ChatDTO) sqlSession.selectOne("mapper.chat.selectChatRoom", ids);
		}
		System.out.println("대화방 생성 작업 : " + dto.getChat_id());
		return dto;
	}

	private void insertNewChatRoom(Map<String, Object> ids) {
		// TODO Auto-generated method stub
		int chatId = selectNewChatId();
		System.out.println("chatId = " + chatId);
		ids.put("chatId", chatId);
		sqlSession.insert("mapper.chat.insertNewChatRoom", ids);
	}

	private int selectNewChatId() {
		// TODO Auto-generated method stub
		if(sqlSession.selectOne("mapper.chat.selectNewChatId") == null) {
			return 1;
		}else return sqlSession.selectOne("mapper.chat.selectNewChatId");
	}

	public List<ChatDTO> selectAllChatList(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.chat.selectAllChatList", id);
	}

	public void insertChatContent(Map<String, Object> ids) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.chat.insertChatContent", ids);
	}

}