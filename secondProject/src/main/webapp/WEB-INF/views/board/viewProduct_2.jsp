<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%
   request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="product" value="${productMap.product }" />
<c:set var="imageFileList" value="${productMap.imageFileList }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   function backToList(obj){
      obj.action="${contextPath}/board/listArticles.do";
      obj.submit();
   }
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.ProductTop{
	display: grid;
    grid-template-columns: 500px 700px;
    height: 500px;
	text-align: left;
	margin-top: 30px;
	justify-content: center;
	align-content: center;
}
.ProductSummary{
	padding-left: 40px;
	display: flex;
    flex-direction: column;
}
.ProductCondition, .ProductSellerId{
	display: flex;
}
.ProductCondition_1, .ProductSellerId_1{
	width:150px;
}

.ProductInfo{
	font-size: 20px;
}
.ProductTitle{
	height : 150px;
	font:bolder;
	font-size: 45px;
}
.ProductPrice{
	font:bolder;
	font-size: 60px;
}
.ProductContent{
	font-size: 20px;
}
.buttons{
    position: relative;
    bottom: -233px;
    height: 50px;
    justify-content: center;
    display: flex;
}
.chatLink{
	width: 30%;
    justify-content: center;
    align-content: center;
    display: flex;
    flex-wrap: wrap;
    background-color: #5a7eff;
    color: white;
    border-radius: 5px;
}
.articleCtrl{
    justify-content: center;
}

.prevProduct, .toList, .nextProduct{
	padding-left: 5px;
    padding-right: 5px;
}
</style>
</head>
<body>
	
	<div class="ProductTop">
		<div class="ProductImage">
			<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="${product.pr_img1}" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="${product.pr_img2}" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="${product.pr_img3}" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="visually-hidden">Next</span>
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
					</button>
				</div>
		</div>
		<div class="ProductSummary">
			<div class="ProductTitle">
				${product.pr_title}
			</div>
			<div class="ProductPrice">
				${product.pr_price }
			</div>
			<div class="ProductInfo">
				<div class="ProductSellerId">
					<div class="ProductSellerId_1">
						판매자
					</div>
					<div class="ProductSellerId_2">
						${product.seller_id }
					</div>		
				</div>
				<div class="ProductCondition">
					<div class="ProductCondition_1">
						상품 상태
					</div>
					<div class="ProductCondition_2">
						${product.pr_condition }
					</div>		
				</div>
			</div>
			<div class="buttons">
				<span class="chatLink" href="#">
					1대1 채팅
				</span>
			</div>
		</div>
	</div>
		<div class="ProductContent">
			${product.pr_content }
		</div>
		<div class="logonActiveButtons">
			<span>
				<input type="button" name="modArticle" value="수정하기">
			</span>
			<span>
				<input type="button" name="removeArticle" value="삭제하기">
			</span>
		</div>
		<div class="articleCtrl">	
			<span class="prevProduct">
				이전글
			</span>
			<span class="toList">
				목록으로
			</span>
			<span class="nextProduct">
				다음글
			</span>
		</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>