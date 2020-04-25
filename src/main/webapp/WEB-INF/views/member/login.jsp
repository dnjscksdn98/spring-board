<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
		<%@ include file="../include/header.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnLogin").click(function() {
					const userId = $("#userId").val();
					const userPw = $("#userPw").val();
					
					if(userId == "") {
						alert("아이디를 입력하십시오");
						$("#userId").focus();
						return;
					}
					if(userPw == "") {
						alert("비밀번호를 입력하십시오");
						$("#userPw").focus();
						return;
					}
					document.login_form.action = "${path}/member/login.do";
					document.login_form.submit();
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>로그인</h2>
		<c:if test="${msg == 'signupSuccess'}">
			<div style="color: blue;">
				성공적으로 가입하셨습니다. 로그인을 하십시오.
			</div>
		</c:if>
		<form name="login_form" method="post">
			<label for="userId">아이디</label>
			<input name="userId" id="userId" />
			<br />
			
			<label for="userPw">비밀번호</label>
			<input name="userPw" id="userPw" type="password" />
			<br />
			
			<button type="button" id="btnLogin">로그인</button>
			<c:if test="${msg == 'loginFailure'}">
				<div style="color: red;">
					아이디 또는 비밀번호가 일치하지 않습니다
				</div>
			</c:if>
		</form>
	</body>
</html>