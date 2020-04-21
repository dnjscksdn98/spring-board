<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${dto.getTitle()}</title>
		<%@ include file="../include/header.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnUpdate").click(function() {
					location.href = "${path}/board/update_view.do?boardId=${dto.getBoardId()}";
				})
				
				$("#btnDelete").click(function() {
					if(confirm("정말로 삭제하시겠습니까?")) {
						location.href = "${path}/board/delete.do?boardId=${dto.getBoardId()}";
					}
				})
				
				$("#btnList").click(function() {
					// 현재 페이지, 검색 옵션, 검색 키워드를 유지한채 목록으로 이동
					location.href = "${path}/board/list.do?curPage=${param.curPage}&searchOption=${param.searchOption}&keyword=${param.keyword}";
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>${dto.getTitle()}</h2>
		<div>
			작성일 :
			<fmt:formatDate value="${dto.getRegDate()}" pattern="yyyy-MM-dd HH:mm:ss" />
		</div>
		<div>
			조회수 :
			${dto.getViews()}
		</div>
		<div>
			작성자 :
			${dto.getWriter()}
		</div>
		<div>
			내용 :
			${dto.getContent()}
		</div>
		<c:if test="${sessionScope.userId == dto.getWriter()}">
			<button id="btnUpdate">수정</button>
			<button id="btnDelete">삭제</button>
		</c:if>
		<button id="btnList">목록</button>
	</body>
</html>