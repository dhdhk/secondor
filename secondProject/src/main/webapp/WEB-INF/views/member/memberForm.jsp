<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<style>
/* 회원가입 버튼 */
.joinButton{
	background-color: #d8d8d8;
	border-style: none;
	color: white;
	border-radius: 3px;
	width: 100px;
	height: 40px;
</style>
<script>
	function readURL(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
				$('#none').attr('style', 'display:none');
				$('#preview').attr('style', '' );
				$('#preview').attr('style', 'object-fit:cover;' );
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<script>
function fn_regIdCheck() {
	let _id = $("#user_id").val();
	if(_id == "") {
		alert("아이디를 입력하세요.");
		$("#user_id").focus();
		return;
	}
	$.ajax({
		type:"post",
		url : '/second/member/idCheck.do',
		dataType:"text",
		data:{user_id:_id},
		success:function(data, textStatus){
			if(data=='unusable') {
				alert("사용할 수 없는 아이디입니다.");
				$('#user_id').attr('style', 'color:red');
				return;
			} else if(data == 'usable') {
				alert("사용할 수 있는 아이디입니다.");
				$('#user_id').attr('style', 'color:#5A7EFF');
				$('#joinButton').prop('disabled', false);
				$('#joinButton').attr('style','background-color: #5A7EFF;');
			}
		}, error:function(data, textStatus){
			alert("에러가 발생했습니다.")
		}
	});
}
//아이디 중복확인을 하고나서 아이디 수정했을때
function checkagain() { 
	$('#user_id').attr('style','');
	$('#joinButton').attr('disabled','disabled');
	$('#joinButton').attr('style','background-color: ##d8d8d8;');
}
</script>

</head>
<body> 
	<div class="memberFormTitle">
		회원 가입
	</div>
	<div class="div_memberForm">
		<form method="post" action="/second/member/addMember.do" enctype="multipart/form-data">
			<table>
				<tr>
					<td rowspan="4" width="400" height="200" align="center">
						<img id="none" src="${contextPath }/resources/image/noImage.png" width="200" height="200" style="">
						<img id="preview" src="#" width="200" height="200" style="display:none;">
					</td>
					<td width="150">
						아이디
					</td>
					<td width="400">
						<input type="text" name="user_id" id="user_id" required="required" style="" onkeypress="checkagain();">
						<input type="button" class="regIdCheck" value="중복 확인" onclick="fn_regIdCheck();">
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
						<input type="file" name="profileimg" onchange="readURL(this);" accept="image/*">
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
						<input type="submit" class="joinButton" id="joinButton" value="가입하기" disabled="disabled">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>