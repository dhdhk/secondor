<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%
   request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/mypage/myChatList_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mypageBody">
		<!-- 사이드바 -->
		<div class="mypageSidebar">
			<div class="profile" >
				<c:if test="${member.profileimg == null}">
					<div class="noProfileImg">No Image</div>
					<%-- <img class="profileImg" src="${contextPath }/resources/image/noprofile.png"> --%>
				</c:if>
				<c:if test="${member.profileimg != null}">
					<img class="profileImg" src="/image/member/${member.user_id }/${member.profileimg}">
				</c:if>
				${member.user_name } 님 
			</div>
			
				<div class="mypageMenu">
			
				<a href="${contextPath }/mypage/modInfoForm.do" class="mypageMenuHref">내 정보</a>
				<a href="${contextPath }/mypage/myArticles.do" class="mypageMenuHref">작성글</a>
				<a href="${contextPath }/chat/chatList.do?id=${member.user_id }" class="mypageMenuHref">1대1 채팅</a>
				<a href="${contextPath }/mypage/logoutForm.do" class="mypageMenuHref">로그아웃</a>
				<br><br><br><br>
				<a href="${contextPath }/mypage/dropOutForm.do" class="mypageMenuHref" style="color:#d0d0d0">회원 탈퇴</a>
		
			</div>
		</div>
		<!-- 본문 -->
		<div class="mypageContent">
			<div class="menuTitle" >
				1대1 채팅 목록
			</div>
			<div class="menuContent">
				<table align="center" width="550px;" class="chatListTable">
						<c:forEach var="chat" items="${chatList}">
							<tr align="left">
								<c:if test="${param.id == chat.buyer_id}"> <!-- 내가 구매자면 (param 수정해야 함)-->
									<td class="chatPurpose" style="color: #5A7EFF;" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${param.id }&&regNum=${chat.pr_id }';">
										구매
									</td>
									<td class="chatInfo" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${param.id }&&regNum=${chat.pr_id }'"><%-- 제품 상세 --%>
										<div class="chatListId">
											${chat.seller_id }님
										</div>
										<div class="chatListPr_title">
											${chat.pr_title }
										</div>
									</td>
									<td class="chatImg" align="center" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${param.id }&&regNum=${chat.pr_id }'"><%-- 제품 이미지 --%>
										<div class="chatListImgDiv">
											<img src="/image/${chat.pr_id }/${chat.pr_img1 }" class="chatListImg" alt="...">
										</div>
									</td>
								</c:if>
								<c:if test="${param.id == chat.seller_id}"> <!-- 내가 판매자면 -->
									<td class="chatPurpose" style="color: #FFCD4A;" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${chat.buyer_id }&&regNum=${chat.pr_id }';">
										판매
									</td>
									<td class="chatInfo" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${chat.buyer_id }&&regNum=${chat.pr_id }';"><%-- 제품 상세 --%>
										<div class="chatListId">
											${chat.buyer_id }님
										</div>
										<div class="chatListPr_title">
											${chat.pr_title }
										</div>
									</td>
									<td class="chatImg" align="center" onclick="location.href='${contextPath }/chat/chatForm.do?buyer_id=${chat.buyer_id }&&regNum=${chat.pr_id }';"><%-- 제품 이미지 --%>
										<div class="chatListImgDiv">
											<img src="/image/${chat.pr_id }/${chat.pr_img1 }" class="chatListImg" alt="...">
										</div>
									</td>
								</c:if>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>