<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container {
	width: 500px;
}

#list {
	height: 300px;
	padding: 15px;
	overflow: auto;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript" >
	$(function() {
		var obj = {
			chat_id : "${chatDTO.chat_id}",
			pr_id : "${chatDTO.pr_id}",
			pr_title : "${chatDTO.pr_title}",
			seller_id : "${chatDTO.seller_id}",
			buyer_id : "${chatDTO.buyer_id}",
			chat_content : "${chatDTO.chat_content}",
			chat_Time : "${chatDTO.chat_Time}"
		};
		let url = "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/chatserver";
		// let url = "ws://localhost:8080/${contextPath}/chatserver";
		let ws;

		ws = new WebSocket(url);
		// 소켓 이벤트 매핑
		ws.onopen = function(evt) {
			console.log('서버 연결 성공');

			// 현재 사용자가 입장했다고 서버에게 통지(유저명 전달)
			$('#msg').attr('disabled', false);
			$('#msg').focus();
		};

		ws.onmessage = function(evt) {
			print('', evt.data);
			let index = evt.data.indexOf("#", 2);
			let no = evt.data.substring(0, 1);
			let user = evt.data.substring(2, index);
			let txt = evt.data.substring(index + 1);

			if (no == '1') {		
				
			} else if (no == '2') {	// 메세지 전송
				if(user == obj.buyer_id){
					print(user, txt);
				} else if(user == obj.seller_id){
					print2(user, txt);
				}
				// else if 관리자_id
			} else if (no == '3') {	// 연결 종료
				print3(user);
			}
			$('#list').scrollTop($('#list').prop('scrollHeight'));
		};

		ws.onclose = function(evt) {
			console.log('소켓이 닫힙니다.');
		};

		ws.onerror = function(evt) {
			console.log(evt.data);
		};

		// 내가 보내면 왼쪽, 온거면 오른쪽
		function print(user, txt) {
			let temp = '';
			temp += '<div style="margin-bottom:3px;" align="left">';
			temp += '[' + user + '] ';
			temp += txt;
			temp += ' <span style="font-size:11px;color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';

			$('#list').append(temp);
		}

		function print2(user, txt) {
			let temp = '';
			temp += '<div style="margin-bottom:3px;" align="right">';
			temp += "[" + user + "]";
			temp += txt;
			temp += ' <span style="font-size:11px;color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';

			$('#list').append(temp);
		}

		$('#msg').keydown(function() {
			if (event.keyCode == 13) {

				//서버에게 메시지 전달
				//2#유저명#메시지
				ws.send('2#' + 'hong' + '#' + $(this).val()); //서버에게

				$('#msg').val(''); // 채팅창 초기화
				$('#msg').focus();

			}
		});

		$('#btnDisconnect').click(function() {
			ws.send('3#' + obj.buyer_id + '#');
			ws.close();

			$('#msg').attr('readonly', true);
			$('#msg').val('');
			$('#msg').attr('disabled', true);
		});

	});
</script>
</head>
<body>
	<!-- 
	<div class="container">
		<h1 class="page-header">${id }님의 채팅창</h1>

		<table class="table table-bordered">
			<tr>w
				<td><input type="text" name="user" id="user"
					class="form-control" placeholder="유저명"></td>
				<td>
					<button type="button" class="btn btn-default" id="btnConnect">연결</button>
					<button type="button" class="btn btn-default" id="btnDisconnect"
						disabled>종료</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><div id="list"></div></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="msg" id="msg"
					placeholder="대화 내용을 입력하세요." class="form-control" disabled></td>
			</tr>
		</table>
	</div>
	 -->
	<div class="container">

		<table class="table table-bordered">
			<tr>
				<td colspan="2"><div>
						<h1 class="page-header">${chatDTO.seller_id }님과의채팅창</h1>
					</div></td>
			</tr>
			<tr>
				<td colspan="2"><div id="list"></div></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="msg" id="msg"
					placeholder="대화 내용을 입력하세요." class="form-control"></td>
			</tr>
			<tr>
				<td><input type="button" class="btn btn-default"
					id="btnDisconnect" value="채팅방 나가기"></td>
			</tr>
		</table>
	</div>
</body>
</html>