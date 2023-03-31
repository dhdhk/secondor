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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
</head>
<body>
  <form name="write" method="post" action="${contextPath }/board/addNewArticle.do">
  	<table align="center" border="9">
  		<tr>
  			<td colspan="3"><input type="text" id="title" placeholder="제목을 입력하세요." size="75" maxlength="15"></td>
  			<td>
  				<select name="category" id="category" >
  					<option value="livingroom">거실</option>
  					<option value="bedroom">침실</option>
  					<option value="kitchen">주방</option>
  					<option value="restroom">화장실</option>
  					<option value="studyroom">서재</option>
  					<option value="etc">기타</option>
  				</select>
  				</td>
  				
  		</tr>
  		<tr>
  			<td colspan="4" ><textarea rows="15" cols="70" maxlength="4000" name="content" placeholder="내용을 입력하세요" style="resize: none;"></textarea></td>
  		</tr>
  		<tr>
  			<td align="left" class="4">이미지파일 첨부 &nbsp;<input type="button" value="파일추가" onclick="fn_addFile()"></td>
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
			