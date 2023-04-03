<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/main_style.css">
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
 .pageNum{
 	clear: both;
    margin-top: auto;
    display: flex;
    align-items: flex-end;
    justify-content: center;
 }
 
</style>
</head>
<body>
<!-- 부트스트랩 card 적용-->

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
					<a href="#">
						<div class="card">
						<!-- **이미지 지정파일 정해지면 수정해야함 -->
							<img src="${board.pr_img1 }"
								class="card-img-top" alt="...">
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
				
				<!-- page 수  보여주기 수정 중 ** 페이지 수가 뜨지 않음 **
					${curpage }/ ${totalpage } 해결해야함
				 -->
				 <div class="pageNum">
				
					<div class="">
						<a href="main.jsp?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a> 
							${curpage } page/ ${totalpage }pages 
						<a href="main.jsp?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">다음</a>
					</div>
					
				</div>  
				
				
				<!-- ignore 실험중 -->

			<!-- pro30 page 보여주기 방법 카피 
			     이건 지금 우리 main.do 에서 화면에 띄워지지 않음
			-->
			<%-- <div class="cls2">
				<c:if test="${totboards != null }">
					<c:choose>
						<c:when test="${totboards > 100 }">
							<c:forEach var="page" begin="1" end="10" step="1">
								<c:if test="${section > 1 &&  page==1 }">
								
								<!-- /main.do or main.do 인지 확인 필요 -->
									<a class="no-uline" href="${contextPath }/main.do?section=${section}&pageNum=${(section-1)*10+1}">&nbsp;pre</a>
								</c:if>
								<a class="no-uline" href="${contextPath }/main.do?section=${section }&pageNum=${page }">${(section-1)*10 + page }</a>
								<c:if test="${page == 10 }">
									<a class="no-uline" href="${contextPath }/main.do?section=${section+1 }&pageNumm=${section*10+1 }">&nbsp;next</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:when test="${totboards == 100 }">
							<c:forEach var="page" begin="1" end="10" step="1">
								<a class="no-uline" href="#">{page}</a>
							</c:forEach>
						</c:when>
						<c:when test="${totboards < 100 }">
							<c:forEach var="page" begin="1" end="${totboards/10 +1 }" step="1">
								<c:choose>
									<c:when test="${page == pageNum }">
										<a class="sel-page" href="${contextPath }/main.do?section=${section }&pageNum=${page }">${page }</a>
									</c:when>
									<c:otherwise>
										<a class="no-uline" href="${contextPath }//main.do?section=${section }&pageNum=${page }">${page }</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
					</c:choose>
				</c:if>
			</div> --%>
			
		</c:when>
	
</c:choose>

</body>

</html>