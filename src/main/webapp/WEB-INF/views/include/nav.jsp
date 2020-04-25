<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl core tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- context path -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<c:choose>
	<c:when test="${sessionScope.userId == null}">
		<a href="${path}/member/login_view.do">로그인</a>
		<a href="${path}/member/signup_view.do">회원가입</a>
	</c:when>
	<c:otherwise>
		${sessionScope.userName}님이 로그인중입니다
		<a href="${path}/member/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
<a href="${path}/board/list.do">게시글</a>

<hr />