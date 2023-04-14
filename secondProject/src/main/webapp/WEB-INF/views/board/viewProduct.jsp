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
<link rel="stylesheet" href="${contextPath }/resources/css/board/viewProduct_style.css">
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
							<img src="/image/${product.regNum }/${product.pr_img1}" class="d-block w-100" alt="...">
						</div>
						<c:if test="${product.pr_img2 != null}">
						<div class="carousel-item">
							<img src="/image/${product.regNum }/${product.pr_img2}" class="d-block w-100" alt="...">
						</div>
						</c:if>
						<c:if test="${product.pr_img3 != null}">
						<div class="carousel-item">
							<img src="/image/${product.regNum }/${product.pr_img3}" class="d-block w-100" alt="...">
						</div>
						</c:if>
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
							<c:if test="${product.pr_condition =='1' }">하</c:if>
							<c:if test="${product.pr_condition =='2' }">중</c:if>
							<c:if test="${product.pr_condition =='3' }">상</c:if>
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
				<div class="ProductSold">
					<div class="ProductSold_1">
						판매상태
					</div>
					<div class="ProductSold_2">
						<c:if test="${product.pr_sold =='0' }">거래 가능</c:if>
						<c:if test="${product.pr_sold =='1' }">거래 중</c:if>
						<c:if test="${product.pr_sold =='2' }">거래 완료</c:if>
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
		<%-- <c:choose>
			로그인 상태 버튼 --%>
			<%-- <c:when test="${isLogOn == true && member != null }">
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
		</c:choose>--%>
	</div>
	<div class="commentContent"><!-- 댓글 part(지저분함) -->
		<form name="comment" method="post" action="" enctype="multipart/form-data">
		<div class="commentViewer">
			<table align="center" border="1px" width="60%">
			<c:choose>
				<c:when test="${isLogOn == true }"><!-- 로그인 시 댓글보임 -->
					<c:choose>
						<c:when test="${empty commentList }"><!-- 댓 없음 -->
						</c:when>
						<c:when test="${not empty commentList  }"><!-- 댓 있음 -->
							<c:choose>
								<c:when test="${member.user_id==product.seller_id }"><!-- 판매자한테 댓글 모두 보임 -->
									<c:forEach var="commentList" items="${commentList }">
									 <tr>
										<td align="left" rowspan="2" >${commentList.buyer_id } ${commentList.regDate }</td>
										<td align="right"><a href="">삭제</a></td>
									</tr>
									<tr>
										<td align="right"><a href="">수정</a></td>
									</tr>
									<tr>
										<td align="left" colspan="2">${commentList.comment_content }</td>
									</tr>
									<tr></tr>
									</c:forEach>
								</c:when>
								<c:otherwise><!-- 판매자가 아닐 시 -->
									<c:forEach var="buyerComments" items="${buyerComments }">
									 <tr>
										<td align="left" rowspan="2" >${buyerComments.buyer_id } ${buyerComments.regDate }</td>
										<td align="right"><a href="">삭제</a></td>
									</tr>
									<tr>
										<td align="right"><a href="">수정</a></td>
									</tr>
									<tr>
										<td align="left" colspan="2">${buyerComments.comment_content }</td>
									</tr>
									<tr></tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>
					<tr>
						<td>
							<input type="text" style="width: 100%;" name="comment_content" placeholder="댓글을 입력하세요">
						</td>
						<td>
							<input type="submit" value="댓글 작성">
						</td>
					</tr>
				</c:when>
			</c:choose>
			</table>
		</div>
	</form>
	</div>
	<!-- 테스트용 --><a href="${contextPath }/modify/modPro.do?regNum=${product.regNum}">수정 이동</a><!-- 수정창 테스트용 -->
	<div class="articleCtrl">	
			<div class="toList" onclick="location.href='#';">
				<c:if test="${pageName != null }">
					<!-- 마이페이지에서 내상품 상세보기에서 다시 내상품 리스트로 돌아가려면 받아올 값이 없으므로 
						<a class="clas1" href="${contextPath }/product/viewProduct.do?regNum=${myList.regNum}&pageName=mypage">
				        pageName을 mypage로 입력해서 쿼리값을 받아옴
					 -->
					<c:if test='${pageName == "mypage" }'>
						<div class="toList" onclick="location.href='${contextPath }/mypage/myArticles.do';">목록으로</div>
					</c:if>
					<!-- 카데고리 상세페이지는 pageName 값을 category_name은 db값으로 받아오니까이렇게 둘 수 있음 -->
					<c:if test='${pageName != "mypage" }'>
						<div class="toList" onclick="location.href='${contextPath }/viewList.do?category_name=${pageName}';">목록으로</div>
					</c:if>
			    </c:if>
				<c:if test="${pageName == null }">
					<div class="toList" onclick="location.href='${contextPath }/main.do';">목록으로</div>
				</c:if>
			</div>
	</div> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>