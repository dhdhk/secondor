<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light fixed-top ">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#"><img src="${contextPath }/resources/image/duke_swing.gif" alt="Bootstrap" width="30" height="24"></a>
    <div class="collapse navbar-collapse " id="navbarTogglerDemo03">
      <form class="d-flex translate-middle" role="search" style="width: 50%">
        <input class="form-control me-2 " type="search" placeholder="Search" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" >검색</button>
      </form>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 " >
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">상품 등록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">회원가입</a>
          <!-- dk -->
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
<!--  <table border="0" width="100%">
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
</table>-->