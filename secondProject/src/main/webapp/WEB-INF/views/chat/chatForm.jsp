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
<link rel="stylesheet" href="${contextPath }/resources/css/chat/chatForm_style.css">
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
			
			var options = { hour: "numeric", minute: "numeric", hour12: false };
			
			let temp = '';
			temp += '<div id="sMA"><div id="sM">';
			temp += $("#message").val();
			temp += ' <span id="sS">'
					+ new Date().toLocaleTimeString("en-US",options) + '</span>';
			temp += '</div></div>';
			console.log(2);

			saveContent(temp, obj.chat_id);
			$("#messageArea").append(temp);
			sock.send($("#message").val());
		}

		// 서버로부터 메시지를 받았을 때
		function onMessage(msg) {
			console.log(3);
			var data = msg.data;
			var options = { hour: "numeric", minute: "numeric", hour12: false };

			let temp = '';
			temp += '<div id="rMA"><div id="rM">';
			temp += data;
			temp += ' <span id="rS">'
					+ new Date().toLocaleTimeString("en-US",options) + '</span>';
			temp += '</div></div>';
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
<body>
	<div class="chatTitle">
		메세지 보내기
	</div>
	<div class="chatContent">
		<div id="chatArea">
			<div id="op">

			</div>
			<div class="chatUpper" align="left" onclick="location.href='${contextPath}/product/viewProduct.do?regNum=${board.regNum }';">
				<div class="chatImgDiv">
					<img src="/image/${board.regNum }/${board.pr_img1}" class="chatImg" alt="...">
				</div>
				<div class="chatSummary">
					<div class="chatWith">
						<c:if test="${id == chatDTO.buyer_id}">
							${chatDTO.seller_id } 님 과의 채팅
						</c:if>
						<c:if test="${id == chatDTO.seller_id}">
							${chatDTO.buyer_id } 님 과의 채팅
						</c:if>
					</div>
					<div class="chatInfo">
						<div class="chatPr_sold">
							<c:if test="${board.pr_sold == 0 }">
								<div class="onSellDisplay" style="color:#5A7EFF;">판매 중</div>
							</c:if>
							<c:if test="${board.pr_sold == 1 }">
								<div class="onSellDisplay" style="color: #FFCD4A;">거래 중</div>
							</c:if>
							<c:if test="${board.pr_sold == 2 }">
								<div class="onSellDisplay" style="color: #f34a5a;">거래 완료</div>
							</c:if>
							<c:if test="${board.pr_sold == 3 }">
								<div class="onSellDisplay" style="color: black;">거래 불가능</div>
							</c:if>
						</div>
						<div class="chatPr_title">
							${board.pr_title }
						</div>
					</div>
					<div class="chatPr_price">
						${board.pr_price }원
					</div>
				</div>
			</div>
				<div id="messageArea" style="overflow-y:scroll" > <!-- 날짜 표기 추가 -->
			</div>
			<div class="sendingArea">
				<div class="inputMessage"><input type="text" id="message" placeholder="메세지 보내기"/></div>
				<div class="sendingButton"><input type="button" id="sendBtn" value="전송" /></div>
			</div>
		</div>
	</div>
</body>
</html>