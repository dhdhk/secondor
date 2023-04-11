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
<c:set var="category_name" value="${product.category_name }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/viewProduct_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   function backToList(obj){
      obj.action="${contextPath}/board/listArticles.do";
      obj.submit();
   }
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="ProductContent">
		<!-- <div class="ProductTop"> -->
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
				${product.pr_price }원
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
				<div class="ProductRegDate">
					<div class="ProductRegDate_1">
						등록일
					</div>
					<div class="ProductCondition_2">
						${product.regDate }
					</div>		
				</div>
			</div>
			<div class="buttons">
				<div class="chatLink" onclick="location.href='#';">
					메세지 보내기
				</div>
			</div>
			
		</div>
		<div class="ProductBottom">
			${product.pr_content }
		</div>
		<c:choose>
			<%-- 로그인 상태 버튼 --%>
			<c:when test="${isLogOn == true && member != null }">
				<div class="logonActiveButtons">
					<span>
						<input type="button" name="modArticle" value="수정하기">
					</span>
					<span>
						<input type="button" name="removeArticle" value="삭제하기">
					</span>
				</div>
			</c:when>
			<c:otherwise>
				<div></div>
			</c:otherwise>
		</c:choose>
	</div>
		<div class="articleCtrl">	
			<!-- <div class="prevProduct" onclick="location.href='#';">
				이전글
			</div> -->
			<c:if test="${pageName != null }">
			<div class="toList" onclick="location.href='${contextPath }/viewList.do?category_name=${pageName}';">
				목록으로
			</div>
			</c:if>
			<c:if test="${pageName == null }">
			<div class="toList" onclick="location.href='${contextPath }/main.do';">
				목록으로
			</div>
			</c:if>
			<!-- <div class="nextProduct" onclick="location.href='#';">
				다음글
			</div> -->
		</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>