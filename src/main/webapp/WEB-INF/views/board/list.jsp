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
					location.href = "${path}/board/write_view.do";
				});
			});
			function list(page) {
				location.href = "${path}/board/list.do?curPage=" + page + "&searchOption=${map.searchOption}&keyword=${map.keyword}";
			}
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
			<c:if test="${sessionScope.userId != null}">
				<button type="button" id="btnWrite">글쓰기</button>
			</c:if>
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
					<!-- 검색조건, 검색 키워드, 현재 페이지를 유지하기 위해 -->
					<a href="${path}/board/detail.do?boardId=${row.getBoardId()}&curPage=${map.boardPager.getCurPage()}&searchOption=${map.searchOption}&keyword=${map.keyword}">
						${row.getTitle()}
					</a>
				</td>
				<td>${row.getWriter()}</td>
				<td>
					<fmt:formatDate value="${row.getRegDate()}" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>${row.getViews()}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<c:if test="${map.boardPager.getCurPage() > 1}">
						<a href="javascript:list('1')">[처음]</a>
					</c:if>
					<c:if test="${map.boardPager.getCurBlock() > 1}">
						<a href="javascript:list('${map.boardPager.getPrevPage()}')">[이전]</a>
					</c:if>
					
					<c:forEach var="num" begin="${map.boardPager.getBlockBegin()}" end="${map.boardPager.getBlockEnd()}">
						<!-- 현재 페이지면 하이퍼링크 제거 -->
						<c:choose>
							<c:when test="${num == map.boardPager.getCurPage()}">
								<span style="color: red;">${num}</span>&nbsp;
							</c:when>
							<c:otherwise>
								<a href="javascript:list('${num}')">${num}</a>&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<c:if test="${map.boardPager.getCurBlock() <= map.boardPager.getTotBlock()}">
						<a href="javascript:list('${map.boardPager.getNextPage()}')">[다음]</a>
					</c:if>
					<c:if test="${map.boardPager.getCurPage() < map.boardPager.getTotPage()}">
						<a href="javascript:list('${map.boardPager.getTotPage()}')">[끝]</a>
					</c:if>
				</td>
			</tr>
		</table>
	</body>
</html>