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
<link rel="stylesheet" href="${contextPath }/resources/css/mypage/dropOut_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function backToList(obj){
		obj.action = "${contextPath}/mypage/mypageMain.do";
		obj.submit();
	}
</script>
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
			
				<a href="${contextPath }/mypage/modInfoForm.do" class="mypageMenuHref">내 정보 관리</a>
				<a href="${contextPath }/mypage/modProfileForm.do" class="mypageMenuHref">프로필 수정</a>
				<a href="${contextPath }/mypage/myArticles.do" class="mypageMenuHref">내 상품</a>
				<a href="${contextPath }/mypage/myChatlistForm.do" class="mypageMenuHref">1대1 채팅</a>
				<a href="${contextPath }/mypage/logoutForm.do" class="mypageMenuHref">로그아웃</a>
				<br><br><br><br>
				<a href="${contextPath }/mypage/dropOutForm.do" class="mypageMenuHref" style="color:#d0d0d0">회원 탈퇴</a>
		
			</div>
		</div>
		<!-- 본문 -->
		<div class="mypageContent">
			<div class="menuTitle" >
				회원 탈퇴
			</div>
			<div class="menuContent">
				<h3>회원 탈퇴 하시겠습니까?</h3>
				<div class="buttons">
					<input type="button" value="탈퇴하기" class="button" onclick="${contextPath}/member/removeMember.do">
					<input type="button" value="돌아가기" class="button" onclick="backToList(this.form)">
				</div>
			</div>
		</div>
	</div>
</body>
</html>