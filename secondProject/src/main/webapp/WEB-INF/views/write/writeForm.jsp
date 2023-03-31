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
<link rel="stylesheet" href="${contextPath }/resources/css/write_style.css">
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
  <form name="write" method="post" action="${contextPath }/board/addNewArticle.do">
  	<br>
  	<br><br><br><br><br>
  	<table align="center" border="9">
  		<tr>
  			<td colspan="4"><input type="text" id="title" placeholder="제목을 입력하세요." size="128" maxlength="15"></td>
  			
  		</tr>
  		<tr>
  			<td colspan="2">
  				<select name="category" id="category" style="background: silver;">
  					<option value="living">거실</option>
  					<option value="bedroom">침실</option>
  					<option value="dining">주방</option>
  					<option value="bathroom">화장실</option>
  					<option value="study">서재</option>
  					<option value="etc">기타</option>
  				</select>
  			</td>
  			<td colspan="2">
  				<input type="text" id="pr_price"  placeholder="가격을 입력하세요" >
  			</td>
  		</tr>
  		<tr>
  			<td colspan="4" ><textarea rows="15" cols="128" maxlength="4000" name="content" placeholder="내용을 입력하세요" style="resize: none;"></textarea></td>
  		</tr>
  		<tr>
  			<td align="left" colspan="4" >이미지파일 첨부 &nbsp;<input type="button" value="파일추가" onclick="fn_addFile()"></td>
  		</tr>
  		<tr>
			<td colspan="4"><div id="d_file"></div></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp;<input type="button" value="목록보기" onclick="backToList(this.form)">
			</td>
		</tr>
  	</table>
  </form>
</body>
</html>
			