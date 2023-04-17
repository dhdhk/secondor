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
<link rel="stylesheet" href="${contextPath }/resources/css/chat/chatList_style.css">
<title>채팅 리스트</title>
</head>
<body>
	<table border="1" align="center" width="800px;">
		<tr align="center" bgcolor="lightgreen">
			<c:forEach var="chat" items="${chatList}">
				<tr align="left">
					<c:if test="${param.id == chat.buyer_id}"> <!-- 내가 구매자면 -->
<%-- 					<td>
							프로필 영역
						</td> --%>
						<td><%-- 제품 상세 --%>
							<div>
								${chat.seller_id }
							</div>
							<div>
								${chat.pr_title }
							</div>
						</td>
						<td><%-- 제품 이미지 --%>
							<div class="chatListImgDiv">
								<img src="/image/${chat.pr_id }/${chat.pr_img1 }" class="chatListImg" alt="...">
							</div>
						</td>
					</c:if>
					<c:if test="${param.id == chat.seller_id}"> <!-- 내가 판매자면 -->
<%-- 					<td>
							프로필 영역
						</td> --%>
						<td><%-- 제품 상세 --%>
							<div>
								${chat.buyer_id }
							</div>
							<div>
								${chat.pr_title }
							</div>
						</td>
						<td><%-- 제품 이미지 --%>
							<div class="chatListImgDiv">
								<img src="/image/${chat.pr_id }/${chat.pr_img1 }" class="chatListImg" alt="...">
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
