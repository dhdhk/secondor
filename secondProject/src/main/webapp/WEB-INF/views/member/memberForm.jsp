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
<script>
	function readURL(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
				$('#preview').attr('style', '' );
				$('#none').attr('style', 'display:none');
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<script>
function fn_regIdCheck() {
	let _id = $("#regId").val();
	if(_id == "") {
		alert("아이디를 입력하세요.");
		$("#regId").focus();
		return;
	}
	$.ajax({
		type:"post",
		url : '/second/member/idCheck.do',
		dataType:"text",
		data:{regId:_id},
		success:function(data, textStatus){
			if(data=='unusable') {
				alert("사용할 수 없는 아이디입니다.");
				$('#regId').attr('style', 'color:red');
				return;
			} else if(data == 'usable') {
				alert("사용할 수 있는 아이디입니다.");
				$('#regId').attr('style', 'color:#5A7EFF');
			}
		}, error:function(data, textStatus){
			alert("에러가 발생했습니다.")
		}
	});
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
						<img id="none" src="${contextPath }/resources/image/noImage.png" width="200" height="200" style="">
						<img id="preview" src="#" width="200" height="200" style="display:none;">
					</td>
					<td width="150">
						아이디
					</td>
					<td width="400">
						<input type="text" name="regId" id="regId" required="required" style="">
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
						<input type="submit" class="joinButton" value="가입하기">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>