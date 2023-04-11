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
<link rel="stylesheet" href="${contextPath }/resources/css/mypage_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mypageBody">
		<!-- 사이드바 -->
		<div class="mypageSidebar">
			<div class="profile" >
				<c:if test="${member.profileimg == ' '}">
					<img class="profileImg" src="${contextPath }/resources/image/newjeans.png">
				</c:if>
				<c:if test="${member.profileimg != ' '}">
					<img class="profileImg" src="${contextPath }/resources/image/noImage.png">
				</c:if>
			${member.user_name} 님
			</div>
			
			<div class="mypageMenu">
			
				<a href="${contextPath }/mypage/modInfoForm.do" class="mypageMenuHref">내 정보 관리</a>
				<a href="${contextPath }/mypage/myArticlesForm.do" class="mypageMenuHref">내 상품</a>
				<a href="${contextPath }/mypage/myChatlistForm.do" class="mypageMenuHref">1대1 채팅</a>
				<a href="${contextPath }/mypage/dropOutForm.do" class="mypageMenuHref">회원 탈퇴</a>
		
			</div>
		</div>
		<!-- 본문 -->
		<div class="mypageContent">
			<div class="menuTitle" >
				작성글
			</div>
			<div class="menuContent">
				<table align="center" border="1" width="60%">
					<tr height="10" align="center" bgcolor="lightgreen">
						<td width="10%">카테고리</td>
						<td width="50%">제목</td>
						<td width="15%">작성일자</td>
						<td width="10%">판매상태</td>
						<td width="7%">선택</td>
					</tr>
					<c:choose>
						<c:when test="${myList == null }">
							<tr height="10">
								<td colspan="5">
									<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
								</td>
							</tr>
						</c:when>
						<c:when test="${myList != null }">
							<c:forEach var="myList" items="${myList }" >
								<tr align="center">
									<td width="10%">${myList.category_name }</td>
									<td align="left" width="50%">
										<span style="padding-right:30px;"></span>
										
												<a class="clas1" href="${contextPath }/product/viewProduct.do?regNum=${myList.regNum}">
													${myList.pr_title }
												</a>
										
									</td>
									<td width="15%"><fmt:formatDate value="${myList.regDate }" /></td>
									<td width="10%">${myList.pr_sold }</td>
									<td width="7%"><input type="checkbox" name="deleteBoard" value="${myList.regNum}"></td>
								</tr>
							</c:forEach>
						</c:when> 
					</c:choose>
					<tr>
						<td colspan="5" align="right" style="border-left: none; border-bottom: none; border-right: none;">
							<input type="button" onclick="${contextPath}/mypage/deleteMyArticle.do" value="삭제하기">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
