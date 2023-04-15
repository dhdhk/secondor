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
<title>회원정보출력창</title>
<c:set var="msg" value="${param.msg }" />
<c:if test="${msg == 'login'}">
	<script>
		window.onload = function(){
			alert('로그인에 성공했습니다.');
		}
	</script>
</c:if>

<c:if test="${msg == 'admindeleteMember'}">
	<script>
		window.onload = function(){
			alert('회원이 삭제되었습니다.');
		}
	</script>
</c:if>

</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>프로필 이미지</b></td>
			<td><b>아이디</b></td>
			<td><b>암호</b></td>
			<td><b>이름</b></td>
			<td><b>이메일</b></td>
			<td><b>주소</b></td>
			<td><b>생년월일</b></td>
			<td><b>전화번호</b></td>
			<td><b>가입일자</b></td>
			<td><b>삭제</b></td>
		</tr>
		<c:forEach var="member" items="${membersList}">
			<tr align="center">
				<td>${member.profileimg }</td>
				<td><%-- <a href="${contextPath}/member/modMemberForm.do?user_id=${member.user_id}"> --%>${member.user_id }</a></td> 
				<td>${member.user_pw }</td>
				<td>${member.user_name }</td>
				<td>${member.user_email }</td>
				<td>${member.user_address }</td>
				<td>${member.user_birth }</td>
				<td>${member.user_phone }</td>
				<td>${member.joinDate }</td>
				<td><a href="${contextPath }/admin/deleteMember.do?user_id=${member.user_id}">삭제하기</a>	
			</tr>
		</c:forEach>
	</table>

</body>
</html>