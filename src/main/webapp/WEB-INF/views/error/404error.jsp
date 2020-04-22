<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>404 Error</title>
		<%@ include file="../include/header.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnHome").click(function() {
					location.href = "${path}/";
				})
			})
		</script>
	</head>
	<body>
		<h2>잘못된 URL입니다.</h2>
		<button id="btnHome">홈으로</button>
	</body>
</html>