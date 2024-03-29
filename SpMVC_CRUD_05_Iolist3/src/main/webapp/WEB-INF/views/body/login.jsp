<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<article class="login-body">
	<form action="${rootPath}/member/login" 
					class="login-form" method="POST">
		<h2>로그인</h2>
		
		<input type="text" name="m_userid" id="m_userid" placeholder="사용자 ID">
		<input type="password" name="m_password" id="m_password" placeholder="비밀번호">
		<button id="btn-login">로그인</button>
		<button type="button" id="btn-join">회원가입</button>
	</form>
</article>