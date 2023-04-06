<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script>
	function backToList(obj){
		obj.action="${contextPath}/board/listArticles.do";
		obj.submit();
	}
</script>
<link rel="stylesheet" href="${contextPath }/resources/css/write_style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<form name="frmArticle" method="post" enctype="multipart/form-data">
	<table border="9" align="center">
		<tr>
			<td colspan="3"></td>
			<td align="right"><input type="button" name="modArticle" value="수정하기"><input type="button" name="removeArticle" value="삭제하기"></td>
		</tr>
		<tr>
			<td rowspan="8" colspan="2"><img src="/image/23/다운로드.jpg" width="200" height="200"/></td>
			<td rowspan="4" colspan="2">제목</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td rowspan="2">작성자</td>
			<td rowspan="2">상태</td>
		</tr>
		<tr></tr>
		<tr>
			<td rowspan="2">가격</td>
			<td rowspan="2">1대1챗</td>
		</tr>
		<tr></tr>
		<tr>
			<td colspan="4" rowspan="15">
				<textarea rows="15" cols="120" style="resize: none;" disabled="disabled" placeholder="임시내용입니다."></textarea>
			</td>
		</tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr>
			<td colspan="4"> </td>
		</tr>
		<tr>
			<td colspan="4"><input type="button" value="<"><input type="button" value="목록으로" onclick="backToList(this.form)"><input type="button" value=">"></td>
		</tr>
	</table>
	</form>
</body>
</html>