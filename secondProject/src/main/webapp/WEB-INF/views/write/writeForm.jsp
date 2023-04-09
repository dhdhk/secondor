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
<script>
	var cnt=1;
	function fn_addFile(){
		if(cnt<4){$("#d_file").append("<br><input type='file' name='pr_img"+cnt+"' accept='image/*'>");
		cnt++;}
		if(cnt==4){$("#d_file").append("<br>사진은 최대 3장까지 등록할 수 있습니다.");
		cnt++;}
		if(cnt>5){}
		
	}
	function backToList(obj){
		obj.action = "${contextPath}/main.do";
		obj.submit();
	}
</script>
<script>
	function onlyNumber(){

        if((event.keyCode<48)||(event.keyCode>57))

           event.returnValue=false;
	}
</script>
</head>
<body>
	<div class="writeForm">
		<form name="write" method="post" action="${contextPath }/write/addNewArticle.do" enctype="multipart/form-data">
			<table align="center" >
		  		<tr>
		  			<td colspan="4">
						<input type="text" name="pr_title" placeholder="제목을 입력하세요." size="118" maxlength="15">
		  			</td>	
		  		</tr>
		  		<tr>
		  			<td>카테고리</td>
		  			<td>
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
		  			<td>
		  				하&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;중&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상
		  			</td>
		  		</tr>
		  		<tr>
		  			<td>상품 가격</td>
		  			<td >
		  				<input type="text" name="pr_price"  placeholder="가격을 입력하세요."  onkeypress="onlyNumber();">
		  			</td>
		  			<td>
		  				<input type="range" name="pr_condition" min="1" max="3">
		  			</td>
		  			
		  		</tr>
		  		<tr>
		  			<td colspan="4" >
		  				<textarea rows="15" cols="120" maxlength="4000" name="pr_content" placeholder="내용을 입력하세요."
		  					wrap="hard" style="resize: none;" >
		  				</textarea>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="left" colspan="2" >
		  				사진 첨부 &nbsp;
		  				<input type="button" name="addFile" value="파일 추가" onclick="fn_addFile()" >
		  			</td>
		  			<td>
		  				
		  			</td>
		  		</tr>
		  		<tr>
					<td colspan="4" align="left">
						<div id="d_file"></div>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="backToList(this.form)">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
			