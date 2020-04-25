<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Invalid Member Error</title>
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
		<h2>Invalid Member Resource Error</h2>
		<p>${msg}</p>
		<button id="btnHome">홈으로</button>
	</body>
</html>