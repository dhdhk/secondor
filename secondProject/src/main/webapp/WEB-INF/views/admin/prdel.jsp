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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function backToList(obj){
		obj.action = "${contextPath}/main.do";
		obj.submit();
	}
</script>
</head>
<body>
>

  	<br><br>

  	<form name="prdel" method="post" action="${contextPath }/admin/deletePr.do" enctype="multipart/form-data">

	<table align="center" border="1" width="70%">

		<tr height="10" align="center" bgcolor="lightgreen">
			<td width="7%">글번호</td>
			<td width="15%">작성자</td>
			<td width="13%">카테고리</td>
			<td width="24%">제목</td>
			<td width="10%">가격</td>
			<td width="10%">작성일자</td>
			<td width="7%">상태</td>
			<td	width="7%">판매여부</td>
			<td width="7%" bgcolor="lightblue">선택</td>
		</tr>
		<c:choose>
			<c:when test="${productList == null }">
				<tr height="10">
					<td colspan="9">
						<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
					</td>
				</tr>
			</c:when>
			<c:when test="${productList != null }">
				<c:forEach var="productList" items="${productList }">
					<tr align="center">
						<td width="7%">${productList.regNum }</td>
						<td width="15%">${productList.seller_id }</td>
						<td width="13%">${productList.category_name }</td>
						<td width="24%"><a href="${contextPath }/product/viewProduct.do?regNum=${productList.regNum}">${productList.pr_title }</a></td>
						<td width="10%">${productList.pr_price }</td>
						<td width="10%"><fmt:formatDate value="${productList.regDate }" /></td>
						<td width="7%">
							<c:if test="${productList.pr_condition =='1' }">하</c:if>
							<c:if test="${productList.pr_condition =='2' }">중</c:if>
							<c:if test="${productList.pr_condition =='3' }">상</c:if>
						</td>
						<td width="7%">
							<c:if test="${productList.pr_sold =='0' }">거래 가능</c:if>
							<c:if test="${productList.pr_sold =='1' }">거래 중</c:if>
							<c:if test="${productList.pr_sold =='2' }">거래 완료</c:if>
						</td>
						<td width="7%"><input type="checkbox" name="deleteselection" value="${productList.regNum }"/></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
		</table>
			
			<br>
		<input type="submit" value="삭제">
		&nbsp;&nbsp;&nbsp;<input type="button" value="취소" onclick="backToList(this.form)">
		</form>
		<br>
		<form name="delsearch" method="post" action="${contextPath }/admin/delsearch.do" enctype="multipart/form-data">
			<input type="text" name="search" width="30%" value="${search }">&nbsp;&nbsp;&nbsp;
			<input type="submit" value="검색">
		</form>
</body>
</html>