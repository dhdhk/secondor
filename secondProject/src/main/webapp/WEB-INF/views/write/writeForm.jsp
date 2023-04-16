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
<style>
/* 숫자필드 오른쪽에 증감화살표 없애기 */
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
</style>
<script>
	
	function backToList(obj){
		obj.action = "${contextPath}/main.do";
		obj.submit();
	}
	function readURL1(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function readURL2(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview2').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function readURL3(input) {
		if(input.files && input.files[0]){
			let reader = new FileReader();
			reader.onload = function(e) {
				$('#preview3').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function remove1(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img1").replaceWith($("#pr_img1").clone(true));
		}else{
		    $("#pr_img1").val("");
		    $('#preview1').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}
	function remove2(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img2").replaceWith($("#pr_img2").clone(true));
		}else{
		    $("#pr_img2").val("");
		    $('#preview2').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}
	function remove3(){
		var agent = navigator.userAgent.toLowerCase();
		//파일초기화
		if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		    $("#pr_img3").replaceWith($("#pr_img3").clone(true));
		}else{
		    $("#pr_img3").val("");
		    $('#preview3').attr('src','${contextPath }/resources/image/noImage.png');
		}
	}
</script>
</head>
<body>
	<div class="writeForm">
		<form name="write" method="post" action="${contextPath }/write/addNewArticle.do" enctype="multipart/form-data">
			<table align="center" >
		  		<tr style="height: 40px;">
		  			<td colspan="4">
						<input type="text" name="pr_title" placeholder="제목을 입력하세요." size="118" maxlength="15" required="required">
		  			</td>	
		  		</tr>
		  		<tr style="height: 40px;">
		  			<td >카테고리</td>
		  			<td >
		  				<select class="choiceCategory_name" name="category_name">
		  					<option value="living">거실</option>
		  					<option value="bedroom">침실</option>
		  					<option value="dining">주방</option>
		  					<option value="bathroom">화장실</option>
		  					<option value="study">서재</option>
		  					<option value="etc">기타</option>
		  				</select>
		  			</td>
		  			<td rowspan="2">
		  				상품 상태
		  			</td>
		  			<td >
		  				하&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;중&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상
		  			</td>
		  		</tr>
		  		<tr style="height: 40px;">
		  			<td>상품 가격</td>
		  			<td>
		  				<input type="number" style="width: 70%;" name="pr_price"  placeholder="가격을 입력하세요."  required="required">
		  			</td>
		  			<td>
		  				<input type="range" name="pr_condition" min="1" max="3" required="required">
		  			</td>
		  			
		  		</tr>
		  		<tr>
		  			<td colspan="4" >
		  				<textarea rows="15" cols="120" maxlength="4000" name="pr_content" placeholder="내용을 입력하세요." wrap="hard" style="resize: none;" ></textarea>
		  			</td>
		  		</tr>
		  		<tr style="height: 40px;">
		  			<td>첫 번째 사진 첨부 <label style="color: red;">(필수)</label></td>
		  			<td>두 번째 사진 첨부</td>
		  			<td colspan="2">세 번째 사진 첨부</td>
		  		</tr>
		  		<tr>
					<td align="center" >
					<div style="max-width: 75%">
							<input type="file" name="pr_img1" accept="image/*" onchange="readURL1(this);" id="pr_img1" required="required"><br>
							<img id="preview1" src="${contextPath }/resources/image/noImage.png" width="150" height="150"><input type="button" id="filecancle" value="×" onclick="remove1()">
					</div>
					</td>
					<td align="center">
					<div style="max-width: 75%">
							<input type="file" name="pr_img2" accept="image/*" onchange="readURL2(this);"><br>
							<img id="preview2" src="${contextPath }/resources/image/noImage.png" width="150" height="150"><input type="button" value="×" onclick="remove2()">
					</div>
					</td>
					<td align="center" colspan="2" >
					<div style="max-width: 75%">
							<input type="file" name="pr_img3" accept="image/*" onchange="readURL3(this);"><br>
							<img id="preview3" src="${contextPath }/resources/image/noImage.png" width="150" height="150"><input type="button" value="×" onclick="remove3()">
					</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="글쓰기">
						<input type="button" value="돌아가기" onclick="backToList(this.form)">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>