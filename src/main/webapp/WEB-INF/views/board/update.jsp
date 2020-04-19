<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 업데이트</title>
		<%@ include file="../include/header.jsp" %>
		<%@ include file="../include/sessionCheck.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnUpdate").click(function() {
					const title = $("#title").val();
					const content = $("#content").val();
					
					if(title === "") {
						alert("제목을 입력하십시오.");
						document.write_form.title.focus();
						return;
					}
					if(content === "") {
						alert("내용을 입력하십시오.");
						document.write_form.content.focus();
						return;
					}
					document.update_form.submit();
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>게시글 업데이트</h2>
		<form name="update_form" method="post" action="${path}/board/update.do">
			<input name="boardId" id="boardId" value="${dto.getBoardId()}" type="hidden" />
			<div>
				제목 :
				<input name="title" id="title" size="100" value="${dto.getTitle()}" />
			</div>
			<div>
				내용 :
				<textarea name="content" id="content" rows="5" cols="100">${dto.getContent()}</textarea> 
			</div>
			<div>
				작성자 : ${dto.getWriter()}
			</div>
			<div style="width: 650px; text-align: center;">
				<button type="button" id="btnUpdate">확인</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</body>
</html>