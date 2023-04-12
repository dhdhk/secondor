<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="result" value="${param.result }"/>
<c:if test="${result == 'findPwFailed' }">
	<script>
	window.onload = function(){
		alert("등록된 회원정보가 없습니다.")
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
		비밀번호 찾기
	</div>
	<div class="findTable">
		<form method="post" action="/second/member/findPw.do">
			<table align="center">
				<tr >
					<td width="150" align="right">
						아이디
					</td>
					<td width="400">
						<input type="text" name="user_id" required="required">
					</td>
				</tr>
				<tr >
					<td width="150" align="right">
						이메일
					</td>
					<td width="400">
						<input type="text" name="user_email" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="button" value="비밀번호 찾기">
					</td>		
				</tr>
			</table>
		</form>
	</div>
</body>
</html>