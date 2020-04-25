<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 작성 페이지</title>
		<%@ include file="../include/header.jsp" %>
		<%@ include file="../include/sessionCheck.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnSave").click(function() {
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
					document.write_form.submit();
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>게시글 작성</h2>
		
		<form name="write_form" method="post" action="${path}/board/write.do">
			<div>
				제목
				<input name="title" id="title" size="100" placeholder="제목을 입력하십시오" />
			</div>
			<div>
				내용
				<textarea name="content" id="content" rows="5" cols="100" placeholder="내용을 입력하십시오"></textarea> 
			</div>
			<div style="width: 650px; text-align: center;">
				<button type="button" id="btnSave">확인</button>
				<button type="reset">취소</button>
			</div>
		</form>
	</body>
</html>