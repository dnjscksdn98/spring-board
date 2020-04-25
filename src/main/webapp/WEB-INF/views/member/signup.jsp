<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
		<%@ include file="../include/header.jsp" %>
		<script>
			$(document).ready(function() {
				$("#btnSignup").click(function() {
					const userId = $("#userId").val();
					const userPw = $("#userPw").val();
					const confirmPw = $("#confirmPw").val();
					const userName = $("#userName").val();
					const userEmail = $("#userEmail").val();
					
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
					if(confirmPw == "") {
						alert("비밀번호 확인을 입력하십시오");
						$("#confirmPw").focus();
						return;
					}
					if(userName == "") {
						alert("이름을 입력하십시오");
						$("#userName").focus();
						return;
					}
					if(userEmail == "") {
						alert("이메일을 입력하십시오");
						$("#userEmail").focus();
						return;
					}
					document.signup_form.action = "${path}/member/signup.do";
					document.signup_form.submit();
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		<h2>회원가입</h2>
		<form name="signup_form" method="post">
			<label for="userId">아이디</label>
			<input name="userId" id="userId" />
			<br />
			
			<label for="userPw">비밀번호</label>
			<input name="userPw" id="userPw" type="password" />
			<br />
			
			<label for="confirmPw">비밀번호 확인</label>
			<input name="confirmPw" id="confirmPw" type="password" />
			<br />
			
			<label for="userName">이름</label>
			<input name="userName" id="userName" />
			<br />
			
			<label for="userEmail">이메일</label>
			<input name="userEmail" id="userEmail" type="email" />
			<br />
			
			<button type="button" id="btnSignup">회원가입</button>
			<c:if test="${msg == 'idError'}">
				<div style="color: red;">
					아이디가 이미 존재합니다
				</div>
			</c:if>
			<c:if test="${msg == 'pwError'}">
				<div style="color: red;">
					비밀번호가 일치하지 않습니다
				</div>
			</c:if>
		</form>
	</body>
</html>