package com.spring.second.chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.second.chat.dao.ChatDAO;
import com.spring.second.chat.dto.ChatDTO;

@Service
public class ChatService {
	@Autowired
	ChatDAO chatDAO;
	
	public ChatDTO searchChatRoom(Map<String, Object> ids) {
		// TODO Auto-generated method stub
		return chatDAO.selectChatRoom(ids);
	}

	public List<ChatDTO> listchats(String id) {
		// TODO Auto-generated method stub
		return chatDAO.selectAllChatList(id);
	}

	public void saveChatContent(Map<String, Object> ids) {
		// TODO Auto-generated method stub
		chatDAO.insertChatContent(ids);
	}
}
