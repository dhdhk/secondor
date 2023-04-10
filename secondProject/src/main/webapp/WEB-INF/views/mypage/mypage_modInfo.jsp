<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br><br>
	<div align="center">
	<form method="post" action="${contextPath }/mypage/modInfo.do">
	<table>
		<tr>
		
			<td align="center"><h4>정보 수정</h4></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>아이디</td>
		</tr>
		<tr>
			<td><input type="text" placeholder="${member.user_id }" readonly="readonly"><input type="hidden" name="user_id" value="${member.user_id }"></td>
		</tr>
		<tr>
			<td>이름</td>
		</tr>
		<tr>
			<td><input type="text" value="${member.user_name }" name="user_name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>	
		</tr>
		<tr>
			<td><input type="password" value="${member.user_pw }" name="user_pw"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>	
		</tr>
		<tr>
			<td><input type="password" name="pwcheck"></td>
		</tr>
		<tr>
			<td>이메일</td>
		</tr>
		<tr>
			<td><input type="email" value="${member.user_email }" name="user_email"></td>
		</tr>
		<tr>
			<td>주소</td>
		</tr>
		<tr>
			<td><input type="text" value="${member.user_address }" name="user_address"></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정하기"><input type="button" value="돌아가기"></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>