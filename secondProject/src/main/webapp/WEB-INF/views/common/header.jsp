<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<table border="0" width="100%">
	<tr>
		<td align="right"><c:choose>
				<c:when test="${isLogOn == true && member != null }">
					<h3>환영합니다. ${member.name }님!</h3>
					<a href="#"><h3>로그아웃</h3></a>
				</c:when>
				<c:otherwise>
					<a href="#"><h3>로그인</h3></a>
				</c:otherwise>
			</c:choose></td>
	</tr>
	<tr>
		<td>
			<a href="${contextPath }/main.do">
				<img src="${contextPath }/resources/image/duke_swing.gif">
			</a>
		</td>
		<td>
			<h1><font size="30">모두홈 - 인테리어 중고거래</font></h1>
		</td>
		<td>
			<a href="#"><h3>상품등록</h3></a>
		</td>
			<td>
			<a href="#"><h3>로그인</h3></a>
		</td>
			<td>
			<a href="#"><h3>1:1 채팅</h3></a>
		</td>
	</tr>
</table>