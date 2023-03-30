<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card-img-top{
	height: 15rem;
	object-fit: cover;
	padding-bottom: 5px;
}
/* .card{
 border-color: :black;
 width: 18rem;
}  */
 
 .card-body{
  height: 70px;
  padding:0px;
 }
 .card-text{
  
  height:10px;
  padding:0px;
 } 
 
 .card-title{
 padding-bottom: 0px;
 }
</style>
</head>
<body>
<!-- 부트스트랩-->


	<div class="row">
		<div class="col-lg-3">
			<div class="card">
				<img src="${contextPath }/resources/image/newjeans.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">뉴진스 파일</h5>
					<p class="card-text">뉴진스 이미지 팝니다</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="card">
				<img src="${contextPath }/resources/image/newjeans.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">뉴진스 파일</h5>
					<p class="card-text">뉴진스 이미지 팝니다</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="card">
				<img src="${contextPath }/resources/image/newjeans.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">뉴진스 파일</h5>
					<p class="card-text">뉴진스 이미지 팝니다</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="card">
				<img src="${contextPath }/resources/image/newjeans.png"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">뉴진스 파일</h5>
					<p class="card-text">뉴진스 이미지 팝니다</p>
				</div>
			</div>
		</div>
	</div>
	<!--eumssooo test -->
</body>
</html>