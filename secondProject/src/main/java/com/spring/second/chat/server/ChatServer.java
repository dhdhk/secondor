package com.spring.second.chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.spring.second.chat.service.ChatService;

@ServerEndpoint("/chatserver")
public class ChatServer {
	@Autowired
	ChatService chatservice;
	
	// ���� ä�� ������ ������ Ŭ���̾�Ʈ(WebSocket Session) ��� (static)
	private static List<Session> list = new ArrayList<Session>();
	
	private void print(String msg) {
		System.out.printf("[%tT] %s\n", Calendar.getInstance(), msg);
	}
	
	@OnOpen
	public void handleOpen(Session session) {
		print(" Ŭ���̾�Ʈ ����");
		list.add(session); // ������ ����(****)
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {		
		
		int index = msg.indexOf("#", 2);
		String no = msg.substring(0, 1); 
		String user = msg.substring(2, index);
		String txt = msg.substring(index + 1);
		
		System.out.println("����onMessage");
		System.out.println("msg=" + msg);
		System.out.println("index=" + index);
		System.out.println("no=" + no);
		System.out.println("user=" + user);
		System.out.println("txt=" + txt);
		
		if (no.equals("1")) {
			// ������ ���� > 1#�ƹ���				-> ���� ó��?
			for (Session s : list) {
				if (s != session) { // ���� �����ڰ� �ƴ� ������ �����
					
					try {
						s.getBasicRemote().sendText("1#" + user + "#");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		} else if (no.equals("2")) {
			// ������ �޼����� ����					-> �޼��� �о��
			for (Session s : list) {
				
				if (s != session) { // ���� �����ڰ� �ƴ� ������ �����
					try {
						s.getBasicRemote().sendText("2#" + user + "#" + txt);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			} 
		} else if (no.equals("3")) {
			// ������ ����
			for (Session s : list) {
				
				if (s != session) { // ���� �����ڰ� �ƴ� ������ �����
					try {
						s.getBasicRemote().sendText("3#" + user + "#");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			System.out.println("���� ����");
			list.remove(session);
		}
	}
	
	@OnClose
	public void handleClose() {
		
	}
	
	@OnError
	public void handleError(Throwable t) {
		
	}

}
/*
public class ChatServer extends TextWebSocketHandler{
    //���� ����Ʈ
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
 
    private static Logger logger = LoggerFactory.getLogger(ChatServer.class);
 
    //Ŭ���̾�Ʈ�� ���� �Ǿ��� �� ����
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        logger.info("{} �����", session.getId()); 
    }
 
    //Ŭ���̾�Ʈ�� ������ ������ �޽����� �������� �� ����
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}�� ���� {} ����", session.getId(), message.getPayload());
        //��� �������� �޼��� ���
        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(message.getPayload()));
        }
    }
    //Ŭ���̾�Ʈ ������ ������ �� ����
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        logger.info("{} ���� ����.", session.getId());
    }
}
*/