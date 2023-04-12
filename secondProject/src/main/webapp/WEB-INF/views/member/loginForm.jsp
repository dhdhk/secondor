<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${contextPath }/resources/css/member/loginForm_style.css">

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="result" value="${param.result }" />
<c:if test="${result == 'loginfailed' }">
	<script>
	window.onload = function(){
		alert("아이디 / 패스워드가 다릅니다. 다시 로그인 하세요.");
	}
	</script>
</c:if>
<c:if test="${result == 'logout' }">
	<script>
	window.onload = function(){
		alert("로그아웃이 되었습니다. 다시 로그인 하세요.");
	}
	</script>
</c:if>
<c:if test="${result == 'notLogin' }">
	<script>
	window.onload = function(){
		alert("로그인 되어 있지 않습니다. 로그인 하세요.");
	}
	</script>
</c:if>

</head>
	<div class="loginFormTitle">
		로그인
	</div>
	<div class="loginTable">
	<form method="post" action="${contextPath }/member/login.do">
		<table align="center">
			<tr align="center">
				<td width="150" align="right">
					아이디
				</td>
				<td width="450">
					<input type="text" name="user_id" style="width: 250px;" required="required">
				</td>
			</tr>
			<tr align="center">
				<td width="150" align="right">
					암호
				</td>
				<td width="450">
					<input type="password" name="user_pw" style="width: 250px;" required="required">
				</td>
			</tr>
			<tr style="height: 50px;">
				<td colspan="2">
					<input type="submit" value="로그인" style="background-color: #5A7EFF; border-style: none;
   					 	color: white; border-radius: 3px; width: 100px; height: 35px;"> 
				</td>
			</tr>
			<tr style="height: 50px;">
				<td colspan="2">
					<button type="button" style="background-color: #5A7EFF; border-style: none;
   					 	color: white; border-radius: 3px; width: 100px; height: 35px;" 
   					 	onclick="location.href='${contextPath }/member/memberForm.do';">
   					 	회원가입
   					 </button>
				</td>
			</tr>
			<tr style="height: 50px;">
				<td colspan="2">
					<button type="button" style="background-color: #5A7EFF; border-style: none;
   					 	color: white; border-radius: 3px; width: 100px; height: 30px; font-size: 13px;" 
   					 	onclick="location.href='${contextPath }/member/findIdForm.do';">
   					 	아이디 찾기
   					 </button>
					<button type="button" style="background-color: #5A7EFF; border-style: none;
   					 	color: white; border-radius: 3px; width: 100px; height: 30px; font-size: 13px;" 
   					 	onclick="location.href='${contextPath }/member/findPwForm.do';">
   					 	비밀번호 찾기
   					 </button>
				</td>
			</tr>
		</table>
	</form>
</div>