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
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath }/resources/css/mypage_style.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="mypageBody">
		<!-- 사이드바 -->
		<div class="mypageSidebar">
			<div class="profile" >
				<c:if test="${member.profileimg == null}">
					<img class="profileImg" src="${contextPath }/resources/image/noprofile.png">
				</c:if>
				<c:if test="${member.profileimg != null}">
					<img class="profileImg" src="/image/member/${member.user_id }/${member.profileimg}">
				</c:if>
			${member.user_name} 님
			</div>
			
			<div class="mypageMenu">
			
				<a href="${contextPath }/mypage/modInfoForm.do" class="mypageMenuHref">내 정보 관리</a>
				<a href="${contextPath }/mypage/myArticles.do" class="mypageMenuHref">내 상품</a>
				<a href="${contextPath }/mypage/myChatlistForm.do" class="mypageMenuHref">1대1 채팅</a>
				<a href="${contextPath }/mypage/dropOutForm.do" class="mypageMenuHref">회원 탈퇴</a>
		
			</div>
		</div>
		<!-- 본문 -->
		<div class="mypageContent">
			<div class="menuTitle" >
				작성글
			</div>
			<div class="menuContent">
				<table align="center" border="1" width="60%">
					<tr height="10" align="center" bgcolor="lightgreen">
						<td width="10%">카테고리</td>
						<td width="50%">제목</td>
						<td width="15%">작성일자</td>
						<td width="10%">판매상태</td>
						<td width="7%">선택</td>
					</tr>
					<c:choose>
						<c:when test="${myList == null }">
							<tr height="10">
								<td colspan="5">
									<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
								</td>
							</tr>
						</c:when>
						<c:when test="${myList != null }">
							<c:forEach var="myList" items="${myList }" >
								<tr align="center">
									<td width="10%">
										<c:if test="${myList.category_name =='living' }">거실</c:if>
										<c:if test="${myList.category_name =='dining' }">주방</c:if>
										<c:if test="${myList.category_name =='bedroom' }">침실</c:if>
										<c:if test="${myList.category_name =='bathroom' }">화장실</c:if>
										<c:if test="${myList.category_name =='study' }">서재</c:if>
										<c:if test="${myList.category_name =='etc' }">기타</c:if>
									</td>
									<td align="left" width="50%">
										<span style="padding-right:30px;"></span>
										
												<a class="clas1" href="${contextPath }/product/viewProduct.do?regNum=${myList.regNum}">
													${myList.pr_title }
												</a>
										
									</td>
									<td width="15%"><fmt:formatDate value="${myList.regDate }" /></td>
									<td width="10%">${myList.pr_sold }</td>
									<td width="7%"><input type="checkbox" name="deleteBoard" value="${myList.regNum}"></td>
								</tr>
								
							</c:forEach>
								<tr>
									<td colspan="5" align="right" style="border-left: none; border-bottom: none; border-right: none;">
										<input type="button" onclick="${contextPath}/mypage/deleteMyArticle.do" value="삭제하기">
									</td>
								</tr>
							
							<!-- 페이징 -->
							<c:set var="page" value="${mh.mp.page}"/> 
							<c:set var="beginPage" value="${mh.beginPage }" />
							<c:set var="endPage" value="${mh.endPage}"/>
							<div class="pageNum">            
								<div class="">
									<c:if test="${beginPage>1 }">
										<a href="${contextPath }/mypage/myArticles.do${mh.mp.getQueryString(beginPage-5)}" class="btn btn-sm btn-info">&lt;</a> 
									</c:if>
									<c:if test="${beginPage<1 }">
										<span class="btn btn-sm btn-info" onclick="alert('이전 페이지가 없습니다')"></span>
									</c:if>
									<c:forEach var="i" begin="0" end="4">
										<c:if test="${beginPage+i  <= endPage }">
											<a class="page ${(page==beginPage+i)? 'paging-active' : ''}" href="${contextPath }/mypage/myArticles.do${mh.mp.getQueryString(beginPage+i)}">${beginPage+i }</a>
										</c:if>
									</c:forEach>
									<c:if test="${beginPage+4<endPage }">
										<a href="${contextPath }/mypage/myArticles.do${mh.mp.getQueryString(beginPage+5)}" class="btn btn-sm btn-success">&gt;</a>
									</c:if>
									<c:if test="${beginPage+4>=endPage }">
										<span class="btn btn-sm btn-info" onclick="alert('다음 페이지가 없습니다')">&gt;</span>
									</c:if>
								</div>
							</div>   
						</c:when> 
					</c:choose>
					
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>