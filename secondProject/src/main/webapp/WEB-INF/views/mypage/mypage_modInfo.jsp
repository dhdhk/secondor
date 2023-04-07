<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br><br>
	<div align="center">
	<form>
	<table>
		<tr>
			<td align="center"><h4>정보 수정</h4></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>아이디</td>
		</tr>
		<tr>
			<td><input type="text" placeholder="user_id" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
		</tr>
		<tr>
			<td><input type="password" placeholder="user_pw" name="user_pw"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
		</tr>
		<tr>
			<td><input type="password" name="pwcheck"></td>
		</tr>
		<tr>
			<td>이메일</td>
		</tr>
		<tr>
			<td><input type="email" placeholder="user_email"></td>
		</tr>
		<tr>
			<td>주소</td>
		</tr>
		<tr>
			<td><input type="text" placeholder="user_address" name="user_address"></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정하기"><input type="button" value="돌아가기"></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>