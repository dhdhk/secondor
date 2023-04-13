<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
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
	<form method="post" action="/second/member/addMember.do" enctype="multipart/form-data">
		<h1 style="text-align:center">회원 가입창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">프로필 사진</p></td>
				<td><img id="preview" src="${contextPath }/resources/image/noprofile.png" width="200" height="200"></td>
			</tr>
			<tr>
				<td width="200"><p align="right"></p></td>
				<td width="400"><input type="file" name="profileimg" onchange="readURL(this);" accept='image/*'></td>
			</tr>
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" name="user_id"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">암호</p></td>
				<td width="400"><input type="password" name="user_pw"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="user_name"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="email" name="user_email"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">주소</p></td>
				<td width="400"><input type="text" name="user_address"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">생년월일</p></td>
				<td width="400"><input type="text" name="user_birth"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">전화번호</p></td>
				<td width="400"><input type="text" name="user_phone"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="가입하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>