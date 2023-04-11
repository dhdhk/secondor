<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function backToLogin(obj){
		obj.action = "${contextPath}/member/loginForm.do";
		obj.submit();
	}
	function findPw(obj){
		obj.action = "${contextPath}/member/findPwForm.do";
		obj.submit();
	}
</script>
</head>
<body>
<br><br><br><br><br>
<form>
<p>회원님의 아이디는  ${requestScope.user_id } 입니다</p>

				<input type="button" value="비밀번호 찾기" onclick="findPw(this.form)">
				<input type="button" value="로그인 화면" onclick="backToLogin(this.form)">
</form>
</body>
</html>