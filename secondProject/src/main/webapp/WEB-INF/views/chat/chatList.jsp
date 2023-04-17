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
<title>채팅 리스트</title>
</head>
<body>
	<table border="1" align="center" width="50%">
		<tr align="center" bgcolor="lightgreen">
			<c:forEach var="chat" items="${chatList}">
				<tr align="left">
					<c:if test="${param.id == chat.buyer_id}"> <!-- 내가 구매자면 -->
						<td>${chat.seller_id }<br>${chat.pr_title }</td>
					</c:if>
					<c:if test="${param.id == chat.seller_id}"> <!-- 내가 판매자면 -->
						<td>${chat.buyer_id }<br>${chat.pr_title }</td>
					</c:if>
					<td><img src="/image/${chat.pr_id }/${chat.pr_img1 }"
						class="d-block w-100" alt="...">
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
