package com.spring.second.chat.dto;

import org.springframework.stereotype.Component;

@Component
public class ChatRoomDTO {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
