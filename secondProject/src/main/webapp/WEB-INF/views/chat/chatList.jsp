<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 리스트</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>chat_id</b></td>
			<td><b>상풍명</b></td>
			<td><b>판매자</b></td>
		</tr>
		<c:forEach var="chat" items="${chatList}">
			<tr align="center">
				<td>${chat.chat_id }</td>
				<td>${chat.pr_title }</td>
				<td>${chat.seller_id }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>







