<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="result" value="${param.result }"/>
<c:if test="${result == 'findIdFailed' }">
	<script>
	window.onload = function(){
		alert("등록된 회원정보가 없습니다. ")
	}
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/second/member/findId.do">
	<table align="center">
		<tr >
			<td width="200"><p align="right">이름</p></td>
			<td width="400"><input type="text" name="user_name"></td>
		</tr>
		<tr >
			<td width="200"><p align="right">이메일</p></td>
			<td width="400"><input type="text" name="user_email"></td>
		</tr>
		<tr >
			<td><p align="right">&nbsp;</p></td>
			<td>
				<input type="submit" value="아이디 찾기">
				<input type="reset" value="다시입력">
			</td>		
		</tr>
	</table>
</form>
</body>
</html>