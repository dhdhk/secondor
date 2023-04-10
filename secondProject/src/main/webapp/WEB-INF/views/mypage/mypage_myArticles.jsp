<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<br><br><br><br>
	<table align="center" border="1" width="60%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<td width="10%">글번호</td>
			<td width="50%">제목</td>
			<td width="15%">작성일자</td>
			<td width="10%">판매상태</td>
			<td width="7%">선택</td>
		</tr>
		<%-- <c:choose>
			<c:when test="${MyArticlesList == null }">
				<tr height="10">
					<td colspan="4">
						<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
					</td>
				</tr>
			</c:when>
			<c:when test="${articlesList != null }">
				<c:forEach var="myList" items="${MyArticlesList }" varStatus="regNum">
					<tr align="center">
						<td width="5%">${regNum.count }</td>
						<td align="left" width="35%">
							<span style="padding-right:30px;"></span>
							<c:choose>
								<c:otherwise>
									<a class="clas1" href="${contextPath }/product/viewProduct.do?regNum=${myList.regNum}">
										${myList.pr_title }
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td width="10%"><fmt:formatDate value="${myList.regDate }" /></td>
						<td width="10%">${myList.pr_sold }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose> --%>
	</table>
</body>
</html>