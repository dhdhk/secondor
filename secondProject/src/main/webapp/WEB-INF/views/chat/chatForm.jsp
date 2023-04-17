<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--<link rel="stylesheet" href="/resources/style.css"> !-->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript">
	$(function() {
		var obj = {
			chat_id : "${chatDTO.chat_id}",
			pr_id : "${chatDTO.pr_id}",
			pr_title : "${chatDTO.pr_title}",
			seller_id : "${chatDTO.seller_id}",
			buyer_id : "${chatDTO.buyer_id}",
			chat_content : '${chatDTO.chat_content}',
			chat_Time : "${chatDTO.chat_Time}"
		};

		$("#sendBtn").click(function() {
			sendMessage();
			$('#message').val('')
		});
		$("#message").keydown(function() {
			if (event.keyCode == 13) {
				sendMessage();
				$('#message').val('')
			}
		});
		
		function saveContent(msg, id){
			$.ajax({
				type: "post",
				contentType: "text/html; charset=UTF-8",
				url: "${contextPath}/chat/saveChatContent.do",
				data: JSON.parse(JSON.stringify(msg + id)),
				success: function(result){
					console.log(msg + id);
				}
			})
		}

		// "http://${pageContext.request.serverName}:${pageContext.request.serverPort}${contextPath}/chatserver";
		let sock = new SockJS("http://localhost:8080/${contextPath}/echo");

		sock.onmessage = onMessage;
		sock.onclose = onClose;
		
		console.log(obj.chat_content);
		$("#messageArea").append(obj.chat_content);

		// 메시지 전송
		function sendMessage() {
			console.log(1);

			let temp = '';
			temp += '<div style="margin-bottom:3px;" align="right">';
			temp += $("#message").val();
			temp += ' <span style="font-size:11px;color:#999;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';
			console.log(2);

			saveContent(temp, obj.chat_id);
			$("#messageArea").append(temp);
			sock.send($("#message").val());
		}

		// 서버로부터 메시지를 받았을 때
		function onMessage(msg) {
			console.log(3);
			var data = msg.data;

			let temp = '';
			temp += '<div style="margin-bottom:3px;" align="left">';
			temp += data;
			temp += ' <span style="font-size:11px;color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';
			console.log(4);

			alert("메세지가 도착했습니다요");
			saveContent(temp, obj.chat_id);
			$("#messageArea").append(temp);
		}

		// 서버와 연결 끊음 -> 채팅창 나감
		function onClose(evt) {
			$("#messageArea").append("연결 끊김");

		}
	});
</script>
</head>
<style>
#chatArea {
	position: absolute;
	width: 300px;
	height: 460px;
	right: 50%;
	left: 50%;
	bottom: 20%;
	border: 1px solid black;
	text-align: center;
}

#messageArea {
	width: 290px;
	height: 380px;
	text-align: right;
}
</style>
<body>
	<div id="chatArea">
		<div id="op">
			<c:if test="${id == chatDTO.buyer_id}">
				<td><h3>${chatDTO.seller_id } 님 과의 채팅</h3></td>
			</c:if>
			<c:if test="${id == chatDTO.seller_id}">
				<td><h3>${chatDTO.buyer_id } 님 과의 채팅</h3></td>
			</c:if>
		</div>
		<div align="left">
			<img src="/image/${product.regNum }/${product.pr_img1}" class="d-block w-100" alt="...">
			${board.pr_sold } || ${board.pr_title } ${board.pr_price }원
		</div>
		<div id="messageArea" style="overflow-y:scroll" > <!-- 날짜 표기 추가 -->
		</div>
		<input type="text" id="message" placeholder="메세지 보내기"/> <input type="button" id="sendBtn" value="전송" />
	</div>
</body>
</html>