<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="proInf" value="${proInf.product }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/write/modifyPro_style.css">
<style>

/* 숫자필드 오른쪽에 증감화살표 없애기 */
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

/* 수정버튼 스타일*/
.filebox label {
	display: inline-flex;
    background-color: #5a7eff;
    color: white;
    cursor: pointer;
    border-radius: 3px;
    height: 35px;
    justify-content: center;
    align-items: center;
    width: 78px;
}

.filebox input[type="file"]{  /* 파일 필드 숨기기 */
	position: absolute;
	width: 12px;
	height: 12px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip:rect(0,0,0,0);
	border: 0;
}
</style>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
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
	function backToList(obj){
		obj.action = "${contextPath}/main.do";
		obj.submit();
	}
</script>
</head>
<body>
	  	<form name="write" method="post" action="${contextPath }/modify/modifyProduct.do?regNum=${proInf.regNum}" enctype="multipart/form-data">
	  		<div class="writeForm">
	  		<table align="center" style="width: 1200px;">
		  		<tr style="height: 40px;">
		  			<td colspan="4">
		  				<input type="text" name="pr_title" value="${proInf.pr_title }" size="118" maxlength="15">
		  			</td>
		  		</tr>
		  		<tr style="height: 40px;">
		  			<td>카테고리</td>
		  			<td>
		  				<select class="choiceCategory_name" name="category_name">
		  					<c:if test="${proInf.category_name=='living' }">
			  					<option value="living" selected="selected">거실</option>
			  					<option value="bedroom">침실</option>
			  					<option value="dining">주방</option>
			  					<option value="bathroom">화장실</option>
			  					<option value="study">서재</option>
			  					<option value="etc">기타</option>
		  					</c:if>
		  					<c:if test="${proInf.category_name=='bedroom' }">
			  					<option value="living" >거실</option>
			  					<option value="bedroom" selected="selected">침실</option>
			  					<option value="dining">주방</option>
			  					<option value="bathroom">화장실</option>
			  					<option value="study">서재</option>
			  					<option value="etc">기타</option>
		  					</c:if>
		  					<c:if test="${proInf.category_name=='dining' }">
			  					<option value="living" >거실</option>
			  					<option value="bedroom">침실</option>
			  					<option value="dining" selected="selected">주방</option>
			  					<option value="bathroom">화장실</option>
			  					<option value="study">서재</option>
			  					<option value="etc">기타</option>
		  					</c:if>
		  					<c:if test="${proInf.category_name=='bathroom' }">
			  					<option value="living" >거실</option>
			  					<option value="bedroom">침실</option>
			  					<option value="dining">주방</option>
			  					<option value="bathroom" selected="selected">화장실</option>
			  					<option value="study">서재</option>
			  					<option value="etc">기타</option>
		  					</c:if>
		  					<c:if test="${proInf.category_name=='study' }">
			  					<option value="living">거실</option>
			  					<option value="bedroom">침실</option>
			  					<option value="dining">주방</option>
			  					<option value="bathroom">화장실</option>
			  					<option value="study" selected="selected">서재</option>
			  					<option value="etc">기타</option>
		  					</c:if>
		  					<c:if test="${proInf.category_name=='etc' }">
			  					<option value="living">거실</option>
			  					<option value="bedroom">침실</option>
			  					<option value="dining">주방</option>
			  					<option value="bathroom">화장실</option>
			  					<option value="study">서재</option>
			  					<option value="etc" selected="selected">기타</option>
		  					</c:if>
		  				</select>
		  			</td>
		  			<td rowspan="2">
		  				상품 상태
		  			</td>
		  			<td>
		  				하&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;중&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상
		  			</td>
		  		</tr>
		  		<tr style="height: 40px;">
		  			<td>상품 가격</td>
		  			<td >
		  				<input type="number" style="width: 70%;" name="pr_price"  value="${proInf.pr_price }"  required="required">
		  			</td>
		  			<td>
		  				<input type="range" name="pr_condition" value="${proInf.pr_condition }" min="1" max="3" required="required">
		  			</td>
		  		</tr>
				<tr style="height: 40px;">
		  			<td colspan="4" align="right">
		  				판매 여부&nbsp;
		  				<select name="pr_sold" style="margin-right: 50px;">
		  					<c:if test="${proInf.pr_sold=='0' }">
		  						<option value="0" selected="selected">거래 가능</option>
			  					<option value="1">거래 중</option>
			  					<option value="2">거래 완료</option>
		  					</c:if>
		  					<c:if test="${proInf.pr_sold=='1' }">
		  						<option value="0">거래 가능</option>
			  					<option value="1" selected="selected">거래 중</option>
			  					<option value="2">거래 완료</option>
		  					</c:if>
		  					<c:if test="${proInf.pr_sold=='2' }">
			  					<option value="0" >거래 가능</option>
			  					<option value="1">거래 중</option>
			  					<option value="2" selected="selected">거래 완료</option>
		  					</c:if>
		  				</select>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td colspan="4" >
		  				<textarea rows="15" cols="120" maxlength="4000" name="pr_content"  wrap="hard" style="resize: none;">${proInf.pr_content }</textarea>
		  			</td>
		  		</tr>		  		
		  		</table>
		  		<table align="center" style="width: 1200px;">
		  		<tr style="height: 40px;">
		  			<td>첫 번째 사진 첨부 <label style="color: red;">(필수)</label></td>
				  	<td>두 번째 사진 첨부</td>
				  	<td>세 번째 사진 첨부</td>
				</tr>
				<tr>
					<!-- input type file 자체의 가로사이즈때문에 table정렬이 자꾸 틀어지더라고요. 그래서 옆에 파일이름나오는 부분을 아예지워버렸습니다.   -->
					<td align="center" style="width: 400px;">
						<div style="max-width: 75%; position: relative;">
							<div id="d_file1" class="filebox">
								<label class="modLabel" for="pr_img1">변경하기</label>
								<input type="file" id="pr_img1" name="pr_img1" accept="image/*"  onchange="readURL1(this);" required="required">
								<input type="hidden" name="pr_img1" value="${proInf.pr_img1 }">
							</div>
							<c:if test="${proInf.pr_img1 ==null }">
								<img id="preview1" src="${contextPath }/resources/image/noImage.png" width="150" height="150">
							</c:if>
							<c:if test="${proInf.pr_img1 !=null }">
								<img id="preview1" src="/image/${proInf.regNum }/${proInf.pr_img1 }" width="150" height="150">
							</c:if>
							<input type="button" class="filecancle" id="filecancle" value="×" onclick="remove1()">
						</div>
					</td>
					<td align="center" style="width: 400px;">
						<div style="max-width: 75%; position: relative;">
							<div id="d_file2" class="filebox">
								<label for="pr_img2">변경하기</label>
								<input type="file" id="pr_img2" name="pr_img2" accept="image/*"  onchange="readURL2(this);">
								<input type="hidden" name="pr_img2" value="${proInf.pr_img2 }">
							</div>
							<c:if test="${proInf.pr_img2 ==null }">
								<img id="preview2" src="${contextPath }/resources/image/noImage.png" width="150" height="150">
							</c:if>
							<c:if test="${proInf.pr_img2 !=null }">
								<img id="preview2" src="/image/${proInf.regNum }/${proInf.pr_img2 }" width="150" height="150">
							</c:if>
							<input type="button" class="filecancle" id="filecancle" value="×" onclick="remove2()">
						</div>
					</td>
					<td align="center" style="width: 400px;">
						<div style="max-width: 75%; position: relative;">
							<div id="d_file3" class="filebox">
								<label for="pr_img3">변경하기</label>
								<input type="file" id="pr_img3" name="pr_img3" accept="image/*"  onchange="readURL2(this);">
								<input type="hidden" name="pr_img3" value="${proInf.pr_img3 }">
							</div>
							<c:if test="${proInf.pr_img3 ==null }">
								<img id="preview3" src="${contextPath }/resources/image/noImage.png" width="150" height="150">
							</c:if>
							<c:if test="${proInf.pr_img3 !=null }">
								<img id="preview3" src="/image/${proInf.regNum }/${proInf.pr_img3 }" width="150" height="150">
							</c:if>
							<input type="button" class="filecancle" id="filecancle" value="×" onclick="remove3()">
						</div>	
					</td>
		  		</tr>
				<tr height="">
					<td colspan="3" align="center" style="height: 60px;">
						<div class="buttons">
							<input type="submit" value="글수정" class="button">
							&nbsp;&nbsp;&nbsp;
							<input type="button" value="취소" class="button" onclick="backToList(this.form)">
						</div>
					</td>
				</tr>
			</table>
			</div>
	  </form>

</body>
</html>
		