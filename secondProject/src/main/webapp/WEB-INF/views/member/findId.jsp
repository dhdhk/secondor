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
<link rel="stylesheet" href="${contextPath }/resources/css/member/findForm_style.css">
</head>
<body>
	<div class="findTitle">
		아이디 찾기
	</div>
	<div class="findTable">
		<form method="post" action="/second/member/findId.do">
			<table align="center">
				<tr >
					<td width="150" align="right">
						이름
					</td>
					<td width="450">
						<input type="text" name="user_name" style="width: 250px;" required="required">
					</td>
				</tr>
				<tr >
					<td width="150" align="right">
						이메일
					</td>
					<td width="450">
						<input type="email" name="user_email" style="width: 250px;" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="button" value="아이디 찾기">
					</td>		
				</tr>
			</table>
		</form>
	</div>
</body>
</html>