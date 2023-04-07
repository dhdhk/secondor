<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!--<c:set var="result" value="${param.result }"/>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/second/member/findPw.do">
	<table align="center">
		<tr >
			<td width="200"><p align="right">아이디</p></td>
			<td width="400"><input type="text" name="user_id"></td>
		</tr>
		<tr >
			<td width="200"><p align="right">이메일</p></td>
			<td width="400"><input type="text" name="user_email"></td>
		</tr>
		<tr >
			<td><p align="right">&nbsp;</p></td>
			<td>
				<input type="submit" value="비밀번호 찾기">
				<input type="reset" value="다시입력">
			</td>		
		</tr>
	</table>
</form>
</body>
</html>