<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light fixed-top ">
	  <table border="0" width="100%">
	  	<tr>
	  	<td>
		  <div class="container-fluid">
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <a class="navbar-brand" href="${contextPath }/main.do"><img src="${contextPath }/resources/image/duke_swing.gif" alt="Bootstrap" width="30" height="24"></a>
		    <div class="collapse navbar-collapse " id="navbarTogglerDemo03">
		      <form class="d-flex translate-middle" role="search" style="width: 50%">
		        <input class="form-control me-2 " type="search" placeholder="Search" aria-label="Search" >
		        <button class="btn btn-outline-success" type="submit" >검색</button>
		      </form>
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0 " >
		      <c:choose>
				<c:when test="${isLogOn == true && member != null }">
					<li class="nav-item"><a class="nav-link" >환영합니다. ${member.name }님!</a></li>
					<li class="nav-item">
				          <a class="nav-link" href="${contextPath }/write/writeForm.do">상품등록</a>
				        </li>
				    <li class="nav-item">
				          <a class="nav-link" href="#">로그아웃</a>
				    </li>
				</c:when>
				<c:otherwise>		
						 <li class="nav-item">
				          <a class="nav-link" href="#">로그인</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="#">회원가입</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="${contextPath }/write/writeForm.do">글쓰기</a>
				        </li>
				</c:otherwise>
			</c:choose>
			 </ul>
		    </div>
		  </div>
		  </td>
		  </tr>
		  <tr>
		  	<td>
		  	<div>
		  		<ul class="navbar-nav me-auto mb-2 mb-lg-0 " >
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=living">거실</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=dining">주방</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=bedroom">침실</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=bathroom">화장실</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=study">서재</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="${contextPath }/viewList.do?category_name=etc">기타</a>
			        </li>
			      </ul>
		  	</div>
		  	</td>
		  </tr>
	  </table>
	</nav>
</body>

