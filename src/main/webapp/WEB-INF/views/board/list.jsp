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
		
		<form name="search_form" method="post" action="${path}/board/list.do">
			<select name="searchOption">
				<option value="all" <c:out value="${map.searchOption == 'all' ? 'selected' : ''}" /> >제목+이름+내용</option>
				<option value="writer" <c:out value="${map.searchOption == 'writer' ? 'selected' : ''}" /> >이름</option>
				<option value="content" <c:out value="${map.searchOption == 'content' ? 'selected' : ''}" /> >내용</option>
				<option value="title" <c:out value="${map.searchOption == 'title' ? 'selected' : ''}" /> >제목</option>
			</select>
			<input name="keyword" value="${map.keyword}" />
			<input type="submit" value="조회" />
			<button type="button" id="btnWrite">글쓰기</button>
		</form>
		
		<!-- 레코드 개수 출력 -->
		${map.count}개의 게시물이 있습니다
		
		<table border="1" style="width: 600px">
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="row" items="${map.list}">
			<tr>
				<td>${row.getBoardId()}</td>
				<td>
					<a href="${path}/board/detail.do?boardId=${row.getBoardId()}">${row.getTitle()}</a>
				</td>
				<td>${row.getWriter()}</td>
				<td>
					<fmt:formatDate value="${row.getRegDate()}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>${row.getViews()}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>