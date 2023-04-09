<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/view_style.css">
</head>

<!-- 부트스트랩 card 적용-->
	<!-- 메인 리스트 -->
	<span>
	<c:choose>
		<c:when test="${boardList == null }">
			<tr height="10">
				<td colspan="4">
					<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
				</td>
			</tr>
		</c:when>
		<c:when test="${boardList != null }">
			<div class="row">
				<c:forEach var="board" items="${boardList }" >
					<div class="col-md-3 mt-4 mb-4">
					<!-- **카드 선택 시 상세페이지로 이동할 수 있게 설정해야함 -->
						<a href="${contextPath }/product/viewProduct.do?regNum=${board.regNum}">
							<div class="card">
							<!-- **이미지 지정파일 정해지면 수정해야함 -->
								<img src="${board.pr_img1 }" class="card-img-top" alt="...">
								<div class="card-body">
								<!-- 카드 내용: ,pr_title, pr_price , pr_sold, regDate  -->
									<h5 class="card-title"> ${board.pr_title }, ${board.pr_sold }</h5>
									<p class="card-text"> ${board.pr_price } , ${board.regDate } </p>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
			
 			<!-- 페이징 -->
			<c:set var="page" value="${ph.page}"/> 
			<c:set var="beginPage" value="${ph.beginPage }" />
			<c:set var="endPage" value="${ph.endPage}"/>
			<div class="pageNum">            
				<div class="">
					<c:if test="${beginPage>1 }">
						<a href="${contextPath }/main.do?page=${beginPage-5 }" class="btn btn-sm btn-info">이전</a> 
					</c:if>
					<!-- 1,2,3,4,5 일때는 이전버튼 안보이게 만들어야함 (css에서) -->
					<c:if test="${beginPage<=1 }">
						<span class="btn btn-sm btn-info" onclick="alert('이전 페이지가 없습니다')">이전</span>
					</c:if>
					<c:forEach var="i" begin="0" end="4">
						<c:if test="${beginPage+i  <= endPage }">
							<a class="${((page==beginPage+i))?'yellow':'' } " href="${contextPath }/main.do?page=${beginPage+i }">${beginPage+i }</a>
						</c:if>
					</c:forEach>
					<c:if test="${beginPage+4<endPage }">
						<a href="${contextPath }/main.do?page=${beginPage+5 }" class="btn btn-sm btn-success">다음</a>
					</c:if>
					<c:if test="${beginPage+4>=endPage }">
						<span class="btn btn-sm btn-info" onclick="alert('다음 페이지가 없습니다')">다음</span>
					</c:if>
				</div>
			</div>   
		</c:when>
	</c:choose>
	</span>


</html>
