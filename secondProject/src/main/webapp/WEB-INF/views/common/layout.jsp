<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath }/resources/css/style.css">
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div id="side-left">
			<tiles:insertAttribute name="sidebar-left"></tiles:insertAttribute>
		</div>
<%-- 		<div id="side-right">
			<tiles:insertAttribute name="side-right"></tiles:insertAttribute>
		</div> --%>
			
		<div id="content">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
			<div id="footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>