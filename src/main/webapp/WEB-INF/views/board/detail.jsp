<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${dto.getTitle()}</title>
		<%@ include file="../include/header.jsp" %>
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
		<button type="button" id="btnUpdate">수정</button>
		<button type="button" id="btnDelete">삭제</button>
	</body>
</html>