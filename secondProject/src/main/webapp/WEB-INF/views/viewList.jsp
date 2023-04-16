<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/view_style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 부트스트랩 card 적용-->
	<!-- 카테고리 별 리스트 -->
	<c:choose>
		<c:when test="${ListByCategory == null }">
			<tr height="10">
				<td colspan="4">
					<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
				</td>
			</tr>
		</c:when>
		<c:when test="${ListByCategory != null }">
			<div class="row">
				<c:forEach var="ListByCategory" items="${ListByCategory }" >
					<div class="col-md-3 mt-4 mb-4" style="cursor: pointer;" onclick="location.href='${contextPath }/product/viewProduct.do?regNum=${ListByCategory.regNum}&pageName=${param.category_name}';">
							<div class="card">
								<c:if test="${ListByCategory.pr_sold =='1' }">
									<div class="onSellDisplay" style="color: #FFCD4A;">거래중</div>
								</c:if>
								<c:if test="${ListByCategory.pr_sold =='2' }">
									<div class="onSellDisplay" style="color: #e45b68;">거래완료</div>
								</c:if>
								<img src="/image/${ListByCategory.regNum }/${ListByCategory.pr_img1 }" class="card-img-top" alt="...">
								<div class="card-body">
								<!-- 카드 내용: ,pr_title, pr_price, regDate  -->
									<h5 class="card-title"> ${ListByCategory.pr_title }</h5>
									<p class="card-text"> ${ListByCategory.pr_price }원 , ${ListByCategory.regDate } </p>
								</div>
							</div>
					</div>
				</c:forEach>
			</div>
			
			<!-- 페이징 -->
	 		<c:set var="page" value="${ch.cc.page}"/> 
			<c:set var="beginPage" value="${ch.beginPage }" />
			<c:set var="endPage" value="${ch.endPage}"/>
			<div class="pageNum">            
				<div class="">
					<c:if test="${beginPage>1 }">
						<a href="${contextPath }/viewList.do${ch.cc.getQueryString(beginPage-5)}" class="btn btn-sm btn-info">&lt;</a> 
					</c:if>
					<c:if test="${beginPage<1 }">
						<span class="btn btn-sm btn-info" onclick="alert('이전 페이지가 없습니다')"></span>
					</c:if>
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${beginPage+i  <= endPage }">
							<a class="page ${(page==beginPage+i)? 'paging-active' : ''}"  href="${contextPath }/viewList.do${ch.cc.getQueryString(beginPage+i)}">${beginPage+i }</a>
						</c:if>
					</c:forEach>
					<c:if test="${beginPage+4<endPage }">
						<a href="${contextPath }/viewList.do${ch.cc.getQueryString(beginPage+5)}" class="btn btn-sm btn-success">&gt;</a>
					</c:if>
					<c:if test="${beginPage+4>=endPage }">
						<span class="btn btn-sm btn-info" onclick="alert('더이상 불러올 페이지가 없습니다')">&gt;</span>
					</c:if>
				</div>
			</div>    
		</c:when>
	</c:choose>
</body>


</html>