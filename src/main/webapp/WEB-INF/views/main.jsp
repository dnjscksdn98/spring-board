<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<%@ include file="./include/header.jsp" %>
	</head>
	<body>
		<%@ include file="./include/nav.jsp" %>
		<h2>홈페이지</h2>
		<c:if test="${msg == 'success'}">
			<h3>${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h2>
		</c:if>
	</body>
</html>