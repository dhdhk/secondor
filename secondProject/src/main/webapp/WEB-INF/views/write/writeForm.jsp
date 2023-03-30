<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>

<body>
  <form name="write" method="post" action="">
  	<table width="80%">
  		<tr>
  			<td><input type="text" id="title" placeholder="제목을 입력하세요."></td>
  		</tr>
  	</table>
  </form>
</body>
</html>