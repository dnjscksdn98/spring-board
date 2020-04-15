<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 목록</title>
		<%@ include file="../include/header.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnWrite").click(function() {
					location.href = "${path}/board/write.do";
				});
			});
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>게시글 목록</h2>
		<button type="button" id="btnWrite">글쓰기</button>
		<table border="1" width="600px">
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.getBoardId()}</td>
				<td>${row.getTitel()}</td>
				<td>${row.getWriter()}</td>
				<td>${row.getRegDate()}</td>
				<td>${row.getViews()}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>