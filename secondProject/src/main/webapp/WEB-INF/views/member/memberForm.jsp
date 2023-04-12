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
<title>회원 가입창</title>
<link rel="stylesheet" href="${contextPath }/resources/css/member/memberForm_style.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function readURL(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

</head>
<body> 
	<div class="memberFormTitle">
		회원 가입
	</div>
	<div class="div_memberForm">
		<form method="post" action="/second/member/addMember.do">
			<table>
				<tr>
					<td rowspan="4" width="400" height="200" align="center">
						<img id="preview" src="#" width="200" height="200">
					</td>
					<td width="150">
						아이디
					</td>
					<td width="400">
						<input type="text" name="user_id" required="required">
					</td>
				</tr>
				<tr>
					<td height="50">
						비밀번호
					</td>
					<td>
						<input type="password" name="user_pw" required="required">
					</td>
				</tr>
				<tr>
					<td height="50">
						이름
					</td>
					<td>
						<input type="text" name="user_name" required="required">
					</td>
				</tr>
				<tr>
					<td height="50">
						생년월일
					</td>
					<td>
						<input type="text" name="user_birth" required="required">
					</td>
				</tr>
				<tr>
					<td rowspan="3" width="300" align="center">
						<p>프로필 사진</p>
						<input type="file" name="profileimg" onchange="readURL(this);" >
					</td>
					<td height="50">
						전화번호
					</td>
					<td>
						<input type="text" name="user_phone" required="required">
					</td>
				</tr>
				<tr>
					<td height="50">
						이메일
					</td>
					<td>
					 	<input type="email" name="user_email" required="required">
					</td>
				</tr>
				<tr>
					<td height="50">
						주소
					</td>
					<td>
						<input type="text" name="user_address" required="required">
					</td>
				</tr>
				<tr>
					<td height="70" colspan="3" align="center">
						<input type="submit" value="가입하기" style="background-color: #5A7EFF; border-style: none;
	   					 	color: white; border-radius: 3px; width: 100px; height: 40px;">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>