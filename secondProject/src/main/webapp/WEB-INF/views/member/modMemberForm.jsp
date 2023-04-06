<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정창</title>
</head>
<body>
	<form method="post" action="/second/member/modMember.do">
		<h1 style="text-align:center">회원 정보 수정창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400">
					<input type="text" name="user_id" value="${member.user_id }" disabled="disabled">
					<input type="hidden" name="user_id" value="${member.user_id }">
				</td>
				
			</tr>
			<tr>
				<td width="200"><p align="right">암호</p></td>
				<td width="400"><input type="password" name="user_pw" value="${member.user_pw }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="user_name" value="${member.user_name }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="email" name="user_email" value="${member.user_email }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">주소</p></td>
				<td width="400"><input type="text" name="user_address" value="${member.user_address }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">생년월일</p></td>
				<td width="400"><input type="text" name="user_birth" value="${member.user_birth }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">전화번호</p></td>
				<td width="400"><input type="text" name="user_phone" value="${member.user_phone }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="수정하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>