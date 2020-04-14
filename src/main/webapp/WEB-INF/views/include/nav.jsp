<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jstl core tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- context path -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<div style="text-align: center;">
	<a href="${path}/board/list.do">게시글</a>
</div>
<hr />