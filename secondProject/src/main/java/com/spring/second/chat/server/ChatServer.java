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
	
	// 현재 채팅 서버에 접속한 클라이언트(WebSocket Session) 목록 (static)
	private static List<Session> list = new ArrayList<Session>();
	
	private void print(String msg) {
		System.out.printf("[%tT] %s\n", Calendar.getInstance(), msg);
	}
	
	@OnOpen
	public void handleOpen(Session session) {
		print(" 클라이언트 연결");
		list.add(session); // 접속자 관리(****)
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
		
		System.out.println("서버onMessage");
		System.out.println("msg=" + msg);
		System.out.println("index=" + index);
		System.out.println("no=" + no);
		System.out.println("user=" + user);
		System.out.println("txt=" + txt);
		
		if (no.equals("1")) {
			// 누군가 접속 > 1#아무개				-> 읽음 처리?
			for (Session s : list) {
				if (s != session) { // 현재 접속자가 아닌 나머지 사람들
					
					try {
						s.getBasicRemote().sendText("1#" + user + "#");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		} else if (no.equals("2")) {
			// 누군가 메세지를 전송					-> 메세지 읽어옴
			for (Session s : list) {
				
				if (s != session) { // 현재 접속자가 아닌 나머지 사람들
					try {
						s.getBasicRemote().sendText("2#" + user + "#" + txt);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			} 
		} else if (no.equals("3")) {
			// 누군가 접속
			for (Session s : list) {
				
				if (s != session) { // 현재 접속자가 아닌 나머지 사람들
					try {
						s.getBasicRemote().sendText("3#" + user + "#");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			System.out.println("소켓 닫음");
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
    //세션 리스트
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
 
    private static Logger logger = LoggerFactory.getLogger(ChatServer.class);
 
    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        logger.info("{} 연결됨", session.getId()); 
    }
 
    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
        //모든 유저에게 메세지 출력
        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(message.getPayload()));
        }
    }
    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        logger.info("{} 연결 끊김.", session.getId());
    }
}
*/